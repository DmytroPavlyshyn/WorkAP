package com.pavlyshyn.ammunition;


public class Shield extends Ammunition {
    public Shield() {
    }

    public Shield(AmmunitionQuality ammunitionQuality, Double weight, Integer price) {
        super(AmmunitionType.SHIELD, ammunitionQuality, weight, price);
    }

    public Shield(AmmunitionType ammunitionType, AmmunitionQuality ammunitionQuality, Double weight, Integer price) {
        super(ammunitionType, ammunitionQuality, weight, price);
    }
}
