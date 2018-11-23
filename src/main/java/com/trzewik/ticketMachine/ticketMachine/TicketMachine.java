package com.trzewik.ticketMachine.ticketMachine;

import com.trzewik.ticketMachine.enums.Coin;

import java.util.HashMap;
import java.util.Map;

public class TicketMachine {

    private Map<Coin, Integer> userCoins;
    private ShoppingCart shoppingCart;
    private CoinContainer coinContainer;
    private Printer printer;


    public TicketMachine(int numberOfPaper, int numberOfCoins) {
        this.printer = new Printer(numberOfPaper);
        this.coinContainer = new CoinContainer(numberOfCoins);
        this.shoppingCart = new ShoppingCart();
        this.userCoins = new HashMap<>();
    }

    public Map<Coin, Integer> getUserCoins() {
        return userCoins;
    }

    public Printer getPrinter() {
        return printer;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public CoinContainer getCoinContainer() {
        return coinContainer;
    }

    public int getValueToPay() {
        return this.shoppingCart.getValueOfCart() - getValueOfUserCoins();
    }

    public int getValueOfUserCoins() {
        return HelperClass.getValueOfCoins(this.userCoins);
    }

    public void addCoinToUserCoins(Coin coin, int numberOfCoinsToAdd) {
        HelperClass.addCoinToMapOfCoins(coin, numberOfCoinsToAdd, this.userCoins);
    }

    public int countRestToPay() {
        return getValueOfUserCoins() - this.shoppingCart.getValueOfCart();
    }

    public void setUserCoins(Map<Coin, Integer> userCoins) {
        this.userCoins = userCoins;
    }

    public void addUserCoinsToCoinContainer() {
        for (Coin coin : this.userCoins.keySet()) {
            this.coinContainer.addCoinToContainer(coin, this.userCoins.get(coin));
        }
    }

    public void clearUserCoins(){
        this.userCoins = new HashMap<>();
    }
}
