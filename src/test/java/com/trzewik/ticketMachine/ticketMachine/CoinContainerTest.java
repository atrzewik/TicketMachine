package com.trzewik.ticketMachine.ticketMachine;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoinContainerTest {

    private CoinContainer coins;

    @Before
    public void initialize(){
        coins = new CoinContainer(5);
    }


    @Test
    public void ifIsEnoughCoinsPayCoinsForUser() {
        assertTrue(coins.isEnoughCoinsPayCoinsForUser(1400));
        assertTrue(coins.getCoinsForUser().size() > 0);
    }

    @Test
    public void ifIsNotEnoughCoinsNotPayCoinsForUser() {
        assertFalse(coins.isEnoughCoinsPayCoinsForUser(4500));
        assertEquals(0, coins.getCoinsForUser().size());
    }
}