package com.pavlyshyn.ammunition;

public class Helmet extends Ammunition {
    public Helmet() {}

    public Helmet(AmmunitionQuality ammunitionQuality, Double weight, Integer price) {
        super(AmmunitionType.HELMET, ammunitionQuality, weight, price);
    }

    public Helmet(AmmunitionType ammunitionType, AmmunitionQuality ammunitionQuality, Double weight, Integer price) {
        super(ammunitionType, ammunitionQuality, weight, price);
    }
}
