package com.trzewik.ticketMachine.ticketMachine;

import com.trzewik.ticketMachine.enums.Coin;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CoinContainer {

    private Map<Coin, Integer> coins;
    private Map<Coin, Integer> coinsForUser;
    private int restToPay;

    public CoinContainer(int numberOfCoins) {
        this.coins = new HashMap<>();
        setCoinContainer(numberOfCoins);
        this.coinsForUser = new HashMap<>();
    }

    public Map<Coin, Integer> getCoinsForUser() {
        return this.coinsForUser;
    }

    public int getValueOfCoinsForUser() {
        return HelperClass.getValueOfCoins(this.coinsForUser);
    }

    public void addCoinToContainer(Coin coin, int numberOfCoinsToAdd) {
        int increasedNumberOfCoins = getNumberOfCoin(coin) + numberOfCoinsToAdd;
        setNumberOfCoin(coin, increasedNumberOfCoins);
    }

    public boolean isEnoughCoinsPayCoinsForUser(int rest) {
        fillCoinsForUser(rest);
        if (getValueOfCoinsForUser() == rest) {
            return true;
        } else {
            setInitialSettings();
            return false;
        }
    }

    private void fillCoinsForUser(int rest) {
        this.restToPay = rest;
        for (Coin coin : getSortedKeys(this.coins)) {
            while (this.coins.get(coin) > 0 && coin.getValue() <= this.restToPay) {
                refillCoinsForUser(coin);
            }
        }
    }

    private List<Coin> getSortedKeys(Map<Coin, Integer> coins) {
        return coins.keySet().stream()
                .sorted(Comparator.comparing(Coin::getValue).reversed())
                .collect(Collectors.toList());
    }

    private void refillCoinsForUser(Coin coin) {
        if (isPossibleRemoveCoinFromContainer(coin, 1)) {
            if (coin.getValue() <= this.restToPay) {
                removeCoinFromContainer(coin, 1);
                addCoinToCoinsForUser(coin, 1);
                this.restToPay -= coin.getValue();
            }
        }

    }

    private void addCoinToCoinsForUser(Coin coin, int numberOfCoinsToAdd) {
        HelperClass.addCoinToMapOfCoins(coin, numberOfCoinsToAdd, this.coinsForUser);
    }

    private boolean isPossibleRemoveCoinFromContainer(Coin coin, int numberOfCoinsToRemove) {
        return getNumberOfCoin(coin) - numberOfCoinsToRemove >= 0;
    }

    private void removeCoinFromContainer(Coin coin, int numberOfCoinsToRemove) {
        int reducedNumberOfCoins = getNumberOfCoin(coin) - numberOfCoinsToRemove;
        setNumberOfCoin(coin, reducedNumberOfCoins);
    }

    private void setInitialSettings() {
        for (Coin coin : this.coinsForUser.keySet()) {
            for (int i = 0; i < this.coinsForUser.get(coin); i++) {
                addCoinToContainer(coin, 1);
            }
        }
        this.coinsForUser = new HashMap<>();
    }

    private void setCoinContainer(int numberOfCoins) {
        for (Coin coin : Coin.values()) {
            setNumberOfCoin(coin, numberOfCoins);
        }
    }

    private void setNumberOfCoin(Coin coin, int numberOfCoins) {
        this.coins.put(coin, numberOfCoins);
    }

    private int getNumberOfCoin(Coin coin) {
        return this.coins.get(coin);
    }
}
