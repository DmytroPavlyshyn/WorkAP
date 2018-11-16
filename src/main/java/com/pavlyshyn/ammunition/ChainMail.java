package com.pavlyshyn.ammunition;

public class ChainMail extends Ammunition {
    private final Integer id = 2;
    public ChainMail() {
    }

    public ChainMail(Double weight, Integer price) {
        super(weight, price);
    }
    public Integer getId() {
        return id;
    }
}
