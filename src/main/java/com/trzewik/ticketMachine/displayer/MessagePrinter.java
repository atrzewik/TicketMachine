package com.trzewik.ticketMachine.displayer;

import com.trzewik.ticketMachine.ticketMachine.TicketMachine;

import java.util.MissingFormatArgumentException;

public class MessagePrinter {

    public static void printUserTickets(TicketMachine ticketMachine){
        printMessage(MessageProvider.giveUserTickets + ticketMachine.getPrinter().printingTickets(ticketMachine.getShoppingCart().getSelectedTickets()));
    }

    public static void printUserRest(TicketMachine ticketMachine){
        printMessage(MessageProvider.giveUserRest, Integer.toString(ticketMachine.getCoinContainer().getValueOfCoinsForUser()/100),
                Integer.toString(ticketMachine.getCoinContainer().getValueOfCoinsForUser()%100), ticketMachine.getCoinContainer().getCoinsForUser().toString());
    }

    public static void printUserCoins(TicketMachine ticketMachine){
        printMessage(MessageProvider.returnUserCoins, Integer.toString(ticketMachine.getValueOfUserCoins()/100),
                Integer.toString(ticketMachine.getValueOfUserCoins()%100), ticketMachine.getUserCoins().toString());
    }

    public static void printMessage(String message, String... formats) {
        try {
            System.out.println(String.format(message, formats));
        } catch (MissingFormatArgumentException ex) {
            throw new MissingFormatArgumentException(MessageProvider.missingFormatArgument);
        }
    }

    public static void printErrorMessage(String errorMessage, String... formats) {
        try {
            System.err.println(String.format(errorMessage, formats));
        } catch (MissingFormatArgumentException ex) {
            throw new MissingFormatArgumentException(MessageProvider.missingFormatArgument);
        }
    }
}
