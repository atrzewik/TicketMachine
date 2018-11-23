package com.trzewik.ticketMachine;

import com.trzewik.ticketMachine.displayer.MessagePrinter;
import com.trzewik.ticketMachine.displayer.MessageProvider;
import com.trzewik.ticketMachine.displayer.UserInputProvider;
import com.trzewik.ticketMachine.enums.Coin;
import com.trzewik.ticketMachine.enums.Ticket;
import com.trzewik.ticketMachine.ticketMachine.TicketMachine;

import java.util.HashMap;

public class Console {

    public static void main(String[] args) {
        TicketMachine ticketMachine = new TicketMachine(2, 50);
        while (true) {
            if (!isPrintingPossible(ticketMachine)) {
                throw new RuntimeException(MessageProvider.tellUserTicketMachineHaveNoPaper);
            }
            ticketChoice(ticketMachine);
            checkIfUserWantMoreTickets(ticketMachine);
            if (!isEnoughPaperToPrintTickets(ticketMachine)) {
                throw new RuntimeException(MessageProvider.tellUserTicketMachineHaveNoPaper);
            }
            paymentAcceptor(ticketMachine);
            checkIfPaymentEnough(ticketMachine);
        }
    }


    private static boolean isPrintingPossible(TicketMachine ticketMachine) {
        return ticketMachine.getPrinter().isEnoughPaper();
    }

    private static void ticketChoice(TicketMachine ticketMachine) {
        for (Ticket ticket : Ticket.values()) {
            MessagePrinter.printMessage(MessageProvider.tellUserTicketOption, ticket.name(),
                    Integer.toString(ticket.getValue() / 100), Integer.toString(ticket.getValue() % 100));
        }
        Ticket ticket = UserInputProvider.collectTicketFromUser(MessageProvider.askUserForTicketChoice);
        ticketMachine.getShoppingCart().addTicketToCart(ticket, 1);
    }

    private static void checkIfUserWantMoreTickets(TicketMachine ticketMachine) {
        while (UserInputProvider.checkExtraTicketChoice(MessageProvider.askUserAboutMoreTickets)) {
            ticketChoice(ticketMachine);
        }
    }

    private static boolean isEnoughPaperToPrintTickets(TicketMachine ticketMachine) {
        return ticketMachine.getPrinter().isEnoughPaperToPrintTickets(ticketMachine.getShoppingCart().getNumberOfTickets());
    }

    private static void paymentAcceptor(TicketMachine ticketMachine) {
        MessagePrinter.printMessage(MessageProvider.askUserForPayment, Integer.toString(ticketMachine.getValueToPay() / 100),
                Integer.toString(ticketMachine.getValueToPay() % 100));
        Coin coin = UserInputProvider.collectCoinFromUser(MessageProvider.askUserForCoins, Coin.FIVE.name(), Coin.TWO.name(), Coin.ONE.name(),
                Coin.FIFTY.name(), Coin.TWENTY.name(), Coin.TEN.name());
        ticketMachine.addCoinToUserCoins(coin, 1);
    }

    private static void checkIfPaymentEnough(TicketMachine ticketMachine) {
        if (ticketMachine.getValueOfUserCoins() == ticketMachine.getShoppingCart().getValueOfCart()) {
            MessagePrinter.printUserTickets(ticketMachine);
            ticketMachine.addUserCoinsToCoinContainer();
            ticketMachine.clearUserCoins();
        } else if (ticketMachine.getValueOfUserCoins() > ticketMachine.getShoppingCart().getValueOfCart()) {
            if (ticketMachine.getCoinContainer().isEnoughCoinsPayCoinsForUser(ticketMachine.countRestToPay())) {
                MessagePrinter.printUserTickets(ticketMachine);
                MessagePrinter.printUserRest(ticketMachine);
                ticketMachine.addUserCoinsToCoinContainer();
                ticketMachine.clearUserCoins();
            } else {
                MessagePrinter.printMessage(MessageProvider.tellUserOnlyCountedCash);
                MessagePrinter.printUserCoins(ticketMachine);
                ticketMachine.setUserCoins(new HashMap<>());
                paymentAcceptor(ticketMachine);
                checkIfPaymentEnough(ticketMachine);
            }
        } else {
            paymentAcceptor(ticketMachine);
            checkIfPaymentEnough(ticketMachine);
        }
    }
}


