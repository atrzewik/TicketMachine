package com.trzewik.ticketMachine.ticketMachine;

import com.trzewik.ticketMachine.enums.Ticket;


import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private Map<Ticket, Integer> selectedTickets;

    public ShoppingCart(){
        this.selectedTickets = new HashMap<>();
    }

    public void addTicketToCart(Ticket ticket, int numberOfTicketToAdd){
        if (this.selectedTickets.get(ticket) == null){
            this.selectedTickets.put(ticket, numberOfTicketToAdd);
        }
        else {
            int increasedNumberOfTickets = this.selectedTickets.get(ticket) + numberOfTicketToAdd;
            this.selectedTickets.put(ticket, increasedNumberOfTickets);
        }
    }


    public Map<Ticket, Integer> getSelectedTickets() {
        return selectedTickets;
    }

    public int getNumberOfTickets(){
        int numberOfTickets = 0;
        for (Ticket ticket : selectedTickets.keySet()){
            numberOfTickets += selectedTickets.get(ticket);
        }
        return numberOfTickets;
    }

    public int getValueOfCart(){
        int value = 0;
        for (Ticket ticket : this.selectedTickets.keySet()){
            value += ticket.getValue() * this.selectedTickets.get(ticket);
        }
        return value;
    }

}
