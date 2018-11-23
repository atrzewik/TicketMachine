package com.trzewik.ticketMachine.displayer;

public class MessageProvider {

    public static String tellUserTicketMachineHaveNoPaper = "Sorry, the ticket machine have no enough paper";

    public static String tellUserTicketOption = "Ticket %s costs %szl %sgr, ";

    public static String askUserForTicketChoice = "Please choose ticket: ";

    public static String askUserAboutMoreTickets = "Would you like buy more tickets? Choose yes or no: ";

    public static String askUserForPayment = "You have to pay %szl %sgr";

    public static String askUserForCoins = "Please pay only: %s , %s, %s, %s, %s or %s coin: ";

    public static String tellUserOnlyCountedCash = "Machine don't have enough money to give a rest, please try again with counted cash";

    public static String missingFormatArgument = "You specified too less format arguments!";

    public static String giveUserTickets = "Please, there are your tickets: ";

    public static String giveUserRest = "Please, there is your rest with value %szl %sgr : %s";

    public static String returnUserCoins = "Please, there are your coins with value %szl %sgr : %s";
}
