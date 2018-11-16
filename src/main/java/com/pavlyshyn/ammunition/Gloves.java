package com.pavlyshyn.ammunition;

public class Gloves  extends Ammunition{
    private final Integer id = 4;
    public Gloves() {
    }

    public Gloves(Double weight, Integer price) {
        super(weight, price);
    }
    public Integer getId() {
        return id;
    }
}
