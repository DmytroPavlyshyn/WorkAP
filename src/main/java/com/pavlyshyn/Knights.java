package com.pavlyshyn;

import com.pavlyshyn.ammunition.Ammunition;
import com.pavlyshyn.iofile.AmmunitionIO;

import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;


public class Knights {
    static Pattern yesPattern = Pattern.compile("\\s*yes\\s*");
    static Pattern noPattern = Pattern.compile("\\s*no\\s*");

    public static void saveData(Knight knight, List<Ammunition> Inventory) throws IOException {
        new AmmunitionIO("Inventory.json").writeToFile(Inventory);
        new AmmunitionIO("KnightsAmmunition.json").writeToFile(knight.getAmmunitions());
    }

    public static void readData(Knight knight, List<Ammunition> Inventory) throws IOException {
        Inventory.addAll(new AmmunitionIO("Inventory.json").readFromFile());
        knight.addAmmunitionAll(new
                AmmunitionIO("KnightsAmmunition.json").readFromFile());
    }

    public static void showPrice(Knight knight) {
        for (Ammunition ammunition : knight.getAmmunitions()) {
            System.out.println("Type " + ammunition.getAmmunitionType() + "Price: " + ammunition.getPrice());
        }
        System.out.println("Total price: " + knight.getPrice());
    }

    public static void showInRange(List<Ammunition> ammunitionList, int minprice, int maxprice) throws Exception {
        if (ammunitionList.isEmpty()) {
            return;
        }
        if (minprice > maxprice) {
            throw new Exception("Incorrect input");
        }
        for (Ammunition ammunition : ammunitionList) {
            if (minprice <= ammunition.getPrice() && ammunition.getPrice() <= maxprice) {
                System.out.println(ammunition);
            }
        }
    }

    public static void addAmmunition(Knight knight, Ammunition ammunition, List<Ammunition> inventory) {
        if (!knight.isEquipped(ammunition)) {
            knight.addAmmunition(ammunition);
            inventory.remove(ammunition);
            Demo.logger.info("" + ammunition + "was successfully dressed on knight");
            return;
        }
        System.out.println("Do you want to change existing " + ammunition.getAmmunitionType().toLowerCase() + " yes/no: ");
        Ammunition temp;
        do {
            String answer = new Scanner(System.in).nextLine();
            if (answer.matches(yesPattern.pattern())) {
                inventory.add(knight.addAmmunition(ammunition));
                inventory.remove(ammunition);
                return;
            } else if (answer.matches(noPattern.pattern())) {
                return;
            } else {
                System.out.println("Incorrect input try again");
            }
        } while (true);
    }

    public static void sort(List<Ammunition> ammunitions) {
        ammunitions.sort((a, b) -> {
            if (a.getWeight() > b.getWeight()) {
                return 1;
            } else if (a.getWeight().equals(b.getWeight())) {
                return 0;
            }
            return -1;
        });
    }

    public static void help() {
        System.out.println("add <AmmunitionType> <Weight> <Price> - wears ammuntion from inventory on knight");
        System.out.println("inrange <knight|inventory> <minprice> <maxprice> - display all ammunition in range by price");
        System.out.println("sort <knight|inventory>- sort ammunition in knight or inventory");
        System.out.println("save - save all your data to files");
        System.out.println("getprice - show total price of knight\'s ammunition");
        System.out.println("knight - show all information about knight");
        System.out.println("inventory - show all inventory");
        System.out.println("read - read data from files");
        System.out.println("close - terminates work of the program");
        System.out.println("help - information about commands");
    }
}
