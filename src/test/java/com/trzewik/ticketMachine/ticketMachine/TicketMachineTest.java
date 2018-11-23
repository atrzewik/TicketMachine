package com.trzewik.ticketMachine.ticketMachine;


import com.trzewik.ticketMachine.enums.Coin;
import com.trzewik.ticketMachine.enums.Ticket;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;

import static org.junit.Assert.*;

public class TicketMachineTest {

    private TicketMachine ticketMachine;

    @Before
    public void initialize(){
        this.ticketMachine = new TicketMachine(2, 3);
        this.ticketMachine.setUserCoins(new HashMap<>(Collections.singletonMap(Coin.FIVE, 1)));
        this.ticketMachine.getShoppingCart().addTicketToCart(Ticket.HP_24H_AG, 1);
    }

    @Test
    public void getValueToPay() {
        assertEquals(500, this.ticketMachine.getValueToPay());
    }

    @Test
    public void getValueOfUserCoins() {
        assertEquals(500, this.ticketMachine.getValueOfUserCoins());
    }

    @Test
    public void addCoinToUserCoins() {
        this.ticketMachine.addCoinToUserCoins(Coin.FIVE, 1);
        assertEquals(1000, this.ticketMachine.getValueOfUserCoins());
    }

    @Test
    public void countRestToPay() {
        this.ticketMachine.addCoinToUserCoins(Coin.FIVE, 2);
        assertEquals(500, this.ticketMachine.countRestToPay());
    }

    @Test
    public void addUserCoinsToCoinContainer() {
        this.ticketMachine.addUserCoinsToCoinContainer();
        assertEquals(0, this.ticketMachine.getValueOfUserCoins());
    }
}