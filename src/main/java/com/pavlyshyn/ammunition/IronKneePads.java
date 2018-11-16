package com.pavlyshyn.ammunition;

public class IronKneePads extends Ammunition {
    private final Integer id = 6;
    public IronKneePads() {
    }

    public IronKneePads(Double weight, Integer price) {
        super(weight, price);
    }
    public Integer getId() {
        return id;
    }
}
