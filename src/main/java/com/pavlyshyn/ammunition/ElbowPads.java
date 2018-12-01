package com.pavlyshyn.ammunition;

public class ElbowPads extends Ammunition {
    public ElbowPads() {
    }

    public ElbowPads(AmmunitionQuality ammunitionQuality, Double weight, Integer price) {
        super(AmmunitionType.ELBOW_PADS, ammunitionQuality, weight, price);
    }

    public ElbowPads(AmmunitionType ammunitionType, AmmunitionQuality ammunitionQuality, Double weight, Integer price) {
        super(ammunitionType, ammunitionQuality, weight, price);
    }
}
