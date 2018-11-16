package com.pavlyshyn;

import com.pavlyshyn.ammunition.*;
import com.pavlyshyn.iofile.AmmunitionReader;
import com.pavlyshyn.iofile.AmmunitionWriter;

import java.io.IOException;
import java.util.*;

public class Knight {
    private List<Ammunition> ammunitions =  new ArrayList<Ammunition>();
    {
        ammunitions.add(new Shield(1.0,2));
        ammunitions.add(new ElbowPads(1.0,2));
        ammunitions.add(new Sword(1.0,2));
        ammunitions.add(new Helmet(1.0,2));
    }

    public Knight() {
    }

    public Knight(List<Ammunition> ammunitions) {
        this.ammunitions = ammunitions;
    }

    public Ammunition addAmmunition(Ammunition ammunition) {
        if(ammunitions.isEmpty()){
            ammunitions.add(ammunition);
        }
        if(!isEquipped(ammunition.getClass())) {
            ammunitions.add(ammunition);
            return null;
        }
        Ammunition temp = findEquipped(ammunition.getClass());
        ammunitions.remove(temp);
        ammunitions.add(ammunition);
        return temp;

    }

    public List<Ammunition> getAmmunitions() {
        return ammunitions;
    }

    public Ammunition findEquipped(Class<? extends Ammunition> ammunitionClass){
        for(Ammunition ammunition:ammunitions){
            if(ammunition.getClass() == ammunitionClass){
                return ammunition;
            }
        }
        return null;
    }

    public boolean isEquipped(Class<? extends Ammunition> ammunitionClass){
        for(Ammunition ammunition:ammunitions){
            if(ammunition.getClass() == ammunitionClass){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Knight{" +
                "ammunitions=" + ammunitions +
                '}';
    }

    public static void main(String[] args) {
        Knight knight = new Knight();
        //AmmunitionWriter ammunitionWriter = new AmmunitionWriter("123.json");
        AmmunitionReader ammunitionReader = new AmmunitionReader("123.json");
//        try {
//         //   ammunitionWriter.writeToFile(knight.getAmmunitions());
//           // ammunitionReader.
//        }catch (IOException e){
//            System.err.println(e);
//        }
////        System.out.println(knight);
////        System.out.println(knight.getAmmunitions().get(1).getId());
    }
}



