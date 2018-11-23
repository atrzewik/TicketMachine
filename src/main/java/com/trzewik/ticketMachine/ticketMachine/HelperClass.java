package com.trzewik.ticketMachine.ticketMachine;

import com.trzewik.ticketMachine.enums.Coin;

import java.util.Map;

public class HelperClass {

    public static int getValueOfCoins(Map<Coin, Integer> coins) {
        int value = 0;
        for (Coin coin : coins.keySet()) {
            value += coin.getValue() * coins.get(coin);
        }
        return value;
    }

    public static void addCoinToMapOfCoins(Coin coin, int numberOfCoinsToAdd, Map<Coin, Integer> coins) {
        if (coins.get(coin) == null) {
            coins.put(coin, numberOfCoinsToAdd);
        } else {
            int increasedNumberOfCoins = coins.get(coin) + numberOfCoinsToAdd;
            coins.put(coin, increasedNumberOfCoins);
        }
    }
}
