package com.pavlyshyn.ammunition;

import com.pavlyshyn.ammunition.Ammunition;

public class Sword extends Ammunition {
    private final Integer id = 8;
    public Sword() {
    }

    public Sword(Double weight, Integer price) {
        super(weight, price);
    }
    public Integer getId() {
        return id;
    }
}
