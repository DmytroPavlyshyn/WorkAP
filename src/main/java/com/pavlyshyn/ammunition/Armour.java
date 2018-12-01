package com.pavlyshyn.ammunition;

public class Armour extends Ammunition {
    public Armour() {
    }

    public Armour(AmmunitionQuality ammunitionQuality, Double weight, Integer price) {
        super(AmmunitionType.ARMOUR, ammunitionQuality, weight, price);
    }

    public Armour(AmmunitionType ammunitionType, AmmunitionQuality ammunitionQuality, Double weight, Integer price) {
        super(ammunitionType, ammunitionQuality, weight, price);
    }
}
