package com.pavlyshyn.ammunition;


public class Sword extends Ammunition {
    public Sword() {
    }

    public Sword(AmmunitionQuality ammunitionQuality, Double weight, Integer price) {
        super(AmmunitionType.SWORD, ammunitionQuality, weight, price);
    }

    public Sword(AmmunitionType ammunitionType, AmmunitionQuality ammunitionQuality, Double weight, Integer price) {
        super(ammunitionType, ammunitionQuality, weight, price);
    }
}
