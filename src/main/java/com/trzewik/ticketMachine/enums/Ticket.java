package com.trzewik.ticketMachine.enums;

public enum Ticket {
    N_1PASS_AG(400),
    N_2PASS(720),
    N_2PASS_AG(760),
    N_20MIN(380),
    N_40MIN_1_PASS(380),
    N_60MIN_AG(500),
    N_90MIN_AG(600),
    N_24H(1500),
    N_24H_AG(2000),
    N_48H(2400),
    N_72H(3600),
    N_7DAYS(4800),
    N_7DAYS_AG(6200),
    HP_1PASS_AG(200),
    HP_2PASS(360),
    HP_2PASS_AG(380),
    HP_20MIN(140),
    HP_40MIN_1_PASS(190),
    HP_60MIN_AG(250),
    HP_90MIN_AG(300),
    HP_24H(750),
    HP_24H_AG(1000),
    HP_48H(1200),
    HP_72H(1800),
    HP_7DAYS(2400),
    HP_7DAYS_AG(3100);


    private final int value;

    Ticket( int value){
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}
