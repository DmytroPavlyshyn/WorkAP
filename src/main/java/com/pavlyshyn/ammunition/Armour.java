package com.pavlyshyn.ammunition;

public class Armour  extends Ammunition{
    private final Integer id = 1;
    public Armour() {
    }
    public Armour(Double weight, Integer price) {
        super(weight, price);
    }
    public Integer getId() {
        return id;
    }

}
