package com.pavlyshyn.ammunition;

import com.pavlyshyn.ammunition.Ammunition;

public class Shield extends Ammunition {
    private final Integer id = 7;
    public Shield() {
    }

    public Shield(Double weight, Integer price) {
        super(weight, price);
    }
    public Integer getId() {
        return id;
    }
}
