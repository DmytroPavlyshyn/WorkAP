package com.pavlyshyn.ammunition;

public class Gloves  extends Ammunition{
    public Gloves() {}

    public Gloves(AmmunitionQuality ammunitionQuality, Double weight, Integer price) {
        super(AmmunitionType.GLOVES, ammunitionQuality, weight, price);
    }

    public Gloves(AmmunitionType ammunitionType, AmmunitionQuality ammunitionQuality, Double weight, Integer price) {
        super(ammunitionType, ammunitionQuality, weight, price);
    }
}
