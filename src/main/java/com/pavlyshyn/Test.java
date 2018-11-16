package com.pavlyshyn;

import com.pavlyshyn.ammunition.Ammunition;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static List<Ammunition> Inventory = new ArrayList<Ammunition>();
    public static List<Ammunition> findAmmunition(int from, int to){

        List<Ammunition> resultInBounds = new ArrayList<Ammunition>();
        for(int i=0; i<Inventory.size(); i++){
            if(!(Inventory.get(i).getPrice()<from&&Inventory.get(i).getPrice()>to)){
                resultInBounds.add(Inventory.get(i));
            }
        }
        return resultInBounds;
    }
    public static void main(String[] args) {
        ObsoleteKnight obsoleteKnight = new ObsoleteKnight("Jack");
        obsoleteKnight.setHelmet(1.0,2)
                .setArmour(2.0,3)
                .setElbowPads(3.0,12)
                .setChainMail(1.0,1)
                .setGloves(2.0,1)
                .setIronKneePads(2.0,4)
                .setSword(4.0,12)
                .setShield(2.0,13);
        System.out.println(obsoleteKnight);
    }
}

