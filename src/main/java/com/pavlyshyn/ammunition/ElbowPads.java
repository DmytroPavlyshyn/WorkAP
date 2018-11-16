package com.pavlyshyn.ammunition;

public class ElbowPads extends  Ammunition{
    private final Integer id = 3;
    public ElbowPads() {
    }

    public ElbowPads(Double weight, Integer price) {
        super(weight, price);
    }
    public Integer getId() {
        return id;
    }
}
