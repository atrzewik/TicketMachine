package com.trzewik.ticketMachine.ticketMachine;

import com.trzewik.ticketMachine.enums.Ticket;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShoppingCartTest {

    private ShoppingCart shoppingCart;

    @Before
    public void initialize(){
        this.shoppingCart = new ShoppingCart();
        this.shoppingCart.addTicketToCart(Ticket.HP_1PASS_AG, 1);
    }

    @Test
    public void addTicketToCart() {
        assertEquals(Ticket.HP_1PASS_AG, this.shoppingCart.getSelectedTickets().keySet().toArray()[0]);
    }

    @Test
    public void getValueOfCart() {
        assertEquals(200, this.shoppingCart.getValueOfCart());
    }
}