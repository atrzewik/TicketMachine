package com.trzewik.ticketMachine.ticketMachine;

import com.trzewik.ticketMachine.enums.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Printer {

    private int numberOfPaper;

    public Printer(int numberOfPaper) {
        this.numberOfPaper = numberOfPaper;
    }

    public boolean isEnoughPaper() {
        return this.numberOfPaper > 0;
    }

    public boolean isEnoughPaperToPrintTickets(int numberOfTickets) {
        return this.numberOfPaper - numberOfTickets >= 0;
    }

    public List<Ticket> printingTickets(Map<Ticket, Integer> tickets) {
        List<Ticket> ticketsToPrint = new ArrayList<>();
        for (Ticket ticket : tickets.keySet()) {
            for (int i = 0; i < tickets.get(ticket); i++) {
                ticketsToPrint.add(ticket);
                this.numberOfPaper --;
            }
        }
        return ticketsToPrint;
    }
}
