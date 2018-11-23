package com.trzewik.ticketMachine.ticketMachine;

import com.trzewik.ticketMachine.enums.Ticket;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class PrinterTest {

    private Printer printer;

    @Before
    public void initialize(){
        this.printer = new Printer(5);
    }

    @Test
    public void printingTickets() {
        Map<Ticket, Integer> tickets = new HashMap<>(Collections.singletonMap(Ticket.HP_1PASS_AG, 1));
        List<Ticket> ticketsToPrint = this.printer.printingTickets(tickets);
        Assert.assertEquals(Ticket.HP_1PASS_AG, ticketsToPrint.get(0));
    }

    @Test
    public void isEnoughPaper() {
        assertTrue(this.printer.isEnoughPaper());
    }
}