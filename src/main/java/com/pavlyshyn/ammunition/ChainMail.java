package com.pavlyshyn.ammunition;

public class ChainMail extends Ammunition {
    public ChainMail() {
    }

    public ChainMail(AmmunitionQuality ammunitionQuality, Double weight, Integer price) {
        super(AmmunitionType.CHAINMAIL, ammunitionQuality, weight, price);
    }

    public ChainMail(AmmunitionType ammunitionType, AmmunitionQuality ammunitionQuality, Double weight, Integer price) {
        super(ammunitionType, ammunitionQuality, weight, price);
    }
}

