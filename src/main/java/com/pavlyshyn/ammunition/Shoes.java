package com.pavlyshyn.ammunition;

public class Shoes extends Ammunition {
    public Shoes() {
    }

    public Shoes(AmmunitionQuality ammunitionQuality, Double weight, Integer price) {
        super(AmmunitionType.SHOES, ammunitionQuality, weight, price);
    }

    public Shoes(AmmunitionType ammunitionType, AmmunitionQuality ammunitionQuality, Double weight, Integer price) {
        super(ammunitionType, ammunitionQuality, weight, price);
    }
}
