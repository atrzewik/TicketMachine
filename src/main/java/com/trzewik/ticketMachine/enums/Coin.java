package com.trzewik.ticketMachine.enums;


public enum Coin {
    FIVE(500),
    TWO(200),
    ONE(100),
    FIFTY(50),
    TWENTY(20),
    TEN(10);

    private final int value;

    Coin( int value){
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}