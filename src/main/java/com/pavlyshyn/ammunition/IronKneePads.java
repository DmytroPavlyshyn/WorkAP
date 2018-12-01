package com.pavlyshyn.ammunition;

public class IronKneePads extends Ammunition {
    public IronKneePads() {
    }

    public IronKneePads(AmmunitionQuality ammunitionQuality, Double weight, Integer price) {
        super(AmmunitionType.IRONKNEEPADS, ammunitionQuality, weight, price);
    }

    public IronKneePads(AmmunitionType ammunitionType, AmmunitionQuality ammunitionQuality, Double weight, Integer price) {
        super(ammunitionType, ammunitionQuality, weight, price);
    }
}
