package com.pavlyshyn;

import com.pavlyshyn.ammunition.*;
import com.pavlyshyn.iofile.AmmunitionWriter;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {
    private static Knight knight = new Knight();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;
        AmmunitionWriter ammunitionWriter = new AmmunitionWriter("456.json");
        List<Ammunition> Inventory = new ArrayList<Ammunition>(Arrays.asList(new Shield(1.0,2),
                new Armour(1.0,2),new Helmet(1.0,2),new ElbowPads(1.0,2)));
        Pattern addPattern =Pattern.compile("\\s*add\\s*(?<Ammunition>\\w+)\\s+(?<Weight>\\d+.\\d+)\\s+(?<Price>\\d+)");
        Matcher matcher;
        while (true){
            command = scanner.nextLine();
            if(command.matches("(?i)\\s*close\\s*")){
                break;
            }
            else if(command.matches("(?i)\\s*save\\s*")){
                try {
                    ammunitionWriter.writeToFile(knight.getAmmunitions());
                }catch (IOException e){
                    System.err.println(e);
                }
            }

            else if(command.matches(addPattern.pattern())){
                matcher = addPattern.matcher(command);
                try {
                  // String s =  matcher.group("Ammunition");
                 //  System.out.println(s);
                }catch (Exception e){
                    System.err.println(e);
                }
            }


        }
    }
}
