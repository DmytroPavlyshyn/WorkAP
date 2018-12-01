package com.pavlyshyn.ammunition;

import com.pavlyshyn.iofile.AmmunitionIO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AmmunitionRandomizer {
    public static List<Ammunition> randomize(int number) {
        List<Ammunition> ammunitions = new ArrayList<>();
        Random random = new Random();
        Integer price;
        Double weight;
        AmmunitionType ammunitionType;
        AmmunitionQuality ammunitionQuality;
        for (int i = 0; i < number; i++) {
            price = random.nextInt(1000);
            weight = 1 + new Random().nextInt(100) + (new Random().nextInt(100) * 1.0) * 0.01;
            ammunitionType = AmmunitionType.values()[random.nextInt(AmmunitionType.values().length)];
            ammunitionQuality = AmmunitionQuality.values()[random.nextInt(AmmunitionQuality.values().length)];
            ammunitions.add(new Ammunition(ammunitionType, ammunitionQuality, weight, price));
        }
        return ammunitions;
    }

    public static void main(String[] args) {
        try {
            new AmmunitionIO("Inventory.json").writeToFile(AmmunitionRandomizer.randomize(100));
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
