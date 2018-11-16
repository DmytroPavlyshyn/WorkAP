package com.pavlyshyn.ammunition;

public class Helmet extends Ammunition {
    private final Integer id = 5;
    public Helmet() {
    }
    public Helmet(Double weight, Integer price) {
        super(weight, price);
    }
    public Integer getId() {
        return id;
    }

}
