package com.pavlyshyn;

import com.pavlyshyn.ammunition.*;
import com.pavlyshyn.iofile.AmmunitionIO;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.pavlyshyn.Knights.*;

public class Demo {
    static Knight knight = new Knight();
    static Scanner scanner = new Scanner(System.in);
    static List<Ammunition> Inventory = new ArrayList<>();
    static Logger logger = Logger.getLogger("Logger");
   static {
        BasicConfigurator.configure();
        try {
            logger.addAppender(new FileAppender(new SimpleLayout(),"logs.txt"));
        }catch (IOException e){
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        String command;
        Pattern addPattern = Pattern.compile("(?i)\\s*add\\s+(?<ammunition>\\w+?)\\s+(?<quality>\\w+?)\\s+?(?<weight>\\d+?\\.\\d+?)\\s+?(?<price>\\d+)");
        Pattern closePattern = Pattern.compile("\\s*close\\s*");
        Pattern savePattern = Pattern.compile("\\s*save\\s*");
        Pattern readPattern = Pattern.compile("\\s*read\\s*");
        Pattern getpricePattern = Pattern.compile("\\s*getprice\\s*");
        Pattern knightPattern = Pattern.compile("\\s*knight\\s*");
        Pattern inventoryPattern = Pattern.compile("\\s*inventory\\s*");
        Pattern sortPattern = Pattern.compile("(?i)\\s*sort\\s+(inventory|knight)\\s*");
        Pattern rangePattern = Pattern.compile("(?i)\\s*inrange\\s+(inventory|knight)\\s+(?<minprice>\\d+?)\\s+(?<maxprice>\\d+)?\\s*");
        Pattern helpPattern = Pattern.compile("\\s*help\\s*");
        Pattern yesPattern = Pattern.compile("\\s*yes\\s*");
        Pattern noPattern = Pattern.compile("\\s*no\\s*");
        Matcher matcher;
        while (true) {
            command = scanner.nextLine();
            if (command.matches(closePattern.pattern())) {
                System.out.println("Do you want to save all your data?");
                command = scanner.nextLine();
                if (command.matches(yesPattern.pattern())) {
                    try {
                        saveData(knight, Inventory);
                    } catch (IOException e) {
                        System.err.println(e);
                    }
                }
                break;
            } else if (command.matches(savePattern.pattern())) {
                try {
                    saveData(knight, Inventory);
                    logger.info("Data was successfully written to files");
                } catch (IOException e) {
                    logger.error(e);
                }
            } else if (command.matches(readPattern.pattern())) {
                try {
                    readData(knight, Inventory);
                    logger.info("Data was successfully read from files");
                } catch (IOException e) {
                    logger.error(e);
                }
            } else if (command.matches(knightPattern.pattern())) {
                System.out.println(knight);
            } else if (command.matches(inventoryPattern.pattern())) {
                System.out.println(Inventory);
            } else if (command.matches(getpricePattern.pattern())) {
                showPrice(knight);
            } else if (command.matches(rangePattern.pattern())) {
                matcher = rangePattern.matcher(command);
                if(matcher.find()){
                    try {
                        if (matcher.group(1).equals("knight")) {
                            showInRange(knight.getAmmunitions(), Integer.parseInt(matcher.group("minprice")),
                                    Integer.parseInt(matcher.group("maxprice")));
                        } else if (matcher.group(1).equals("inventory")) {
                            showInRange(Inventory, Integer.parseInt(matcher.group("minprice")),
                                    Integer.parseInt(matcher.group("maxprice")));
                        }
                    }catch (Exception e){
                        System.err.println(e);
                    }
                }
            }else if (command.matches(sortPattern.pattern())) {
                matcher = sortPattern.matcher(command);
                if (matcher.find()) {
                    if (matcher.group(1).equals("(?i)knight")) {
                        sort(knight.getAmmunitions());
                    } else if (matcher.group(1).matches("(?i)inventory")) {
                        sort(Inventory);
                    }
                }
            } else if (command.matches(addPattern.pattern())) {
                matcher = addPattern.matcher(command);
                if (matcher.find()) {
                    for (Ammunition ammunition : Inventory) {
                        if (ammunition.getAmmunitionType().matches("(?i)" + matcher.group("ammunition")) &&
                                (ammunition.getAmmunitionQuality().toString().matches("(?i)" + matcher.group("quality")) &&
                                        (ammunition.getWeight().equals(Double.parseDouble(matcher.group("weight")))) &&
                                        (ammunition.getPrice().equals(Integer.parseInt(matcher.group("price")))))) {
                            addAmmunition(knight, ammunition, Inventory);
                            break;
                        }
                    }
                }
            } else if (command.matches(helpPattern.pattern())) {
                help();
            }


        }
    }
}


