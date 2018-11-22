package com.pavlyshyn.ammunition;

import com.pavlyshyn.iofile.AmmunitionIO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AmmuntionRandomizer {
    public static List<Ammunition> randomize(int number){
        List<Ammunition> ammunitions = new ArrayList<>();
        Random random = new Random();
        Integer price;
        Double weight;
        AmmunitionType ammunitionType;
        AmmunitionQuality ammunitionQuality;
        for(int i = 0; i < number; i++){
            price = random.nextInt(1000);
            weight = random.nextDouble();
            ammunitionType = AmmunitionType.values()[random.nextInt(AmmunitionType.values().length-1)];
            ammunitionQuality = AmmunitionQuality.values()[random.nextInt(AmmunitionQuality.values().length-1)];
            ammunitions.add(new Ammunition(ammunitionType,ammunitionQuality,weight,price));
        }
        return ammunitions;
    }

    public static void main(String[] args) {
        try {
            new AmmunitionIO("Inventory.json").writeToFile(AmmuntionRandomizer.randomize(20));
        }
        catch (Exception e){
            System.err.println(e);
        }
    }
}
