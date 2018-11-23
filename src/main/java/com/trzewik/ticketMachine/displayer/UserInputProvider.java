package com.trzewik.ticketMachine.displayer;


import com.trzewik.ticketMachine.enums.Coin;
import com.trzewik.ticketMachine.enums.Ticket;

import java.util.Scanner;

public class UserInputProvider {

    public static Ticket collectTicketFromUser(String message, String... formats) {
        while (true) {
            try {
                return ticketMatcher(collectString(message, formats));
            } catch (Exception e) {
                MessagePrinter.printErrorMessage("You specified wrong ticket!");
            }
        }
    }

    public static Ticket ticketMatcher(String userInput) {
        for (Ticket ticket : Ticket.values()) {
            if (ticket.name().equals(userInput.toUpperCase())) {
                return ticket;
            }
        }
        throw new IllegalArgumentException("You specified wrong input!");
    }

    public static Coin collectCoinFromUser(String message, String... formats) {
        while (true) {
            try {
                return coinMatcher(collectString(message, formats));
            } catch (Exception e) {
                MessagePrinter.printErrorMessage("You give wrong coin!");
            }
        }
    }

    public static Coin coinMatcher(String userInput) {
        for (Coin coin : Coin.values()) {
            if (coin.name().equals(userInput.toUpperCase())) {
                return coin;
            }
        }
        throw new IllegalArgumentException("You specified wrong input!");
    }

    public static boolean checkExtraTicketChoice(String message, String... formats) {
        return collectString(message, formats).equals("yes");
    }

    public static String collectString(String message, String... formats) {
        while (true) {
            try {
                Scanner userInput = getMessage(message, formats);
                return userInput.nextLine();
            } catch (Exception e) {
                MessagePrinter.printErrorMessage("Input must be a string! Try again: ");
            }
        }
    }

    private static Scanner getMessage(String message, String... formats) {
        Scanner userInput = new Scanner(System.in);
        MessagePrinter.printMessage(message, formats);
        return userInput;
    }
}
