package com.pavlyshyn;

import com.pavlyshyn.ammunition.*;

import java.util.*;

public class Knight {
    private String name;
    private List<Ammunition> ammunitions = new ArrayList<>();

    public Knight() {
    }
    public Knight(String name) {
        this.name = name;
    }

    public Knight(String name, List<Ammunition> ammunitions) {
        this.name = name;
        this.ammunitions = ammunitions;
    }

    public Ammunition addAmmunition(Ammunition ammunition) {
        if (ammunitions.isEmpty()) {
            ammunitions.add(ammunition);
            return null;
        }
        if (!isEquipped(ammunition)) {
            ammunitions.add(ammunition);
            return null;
        }
        Ammunition temp = findEquipped(ammunition);
        ammunitions.remove(temp);
        ammunitions.add(ammunition);
        Demo.logger.info("" + ammunition + "was successfully dressed on knight, and " + temp + " was put to inventory");
        return temp;
    }

    public List<Ammunition> addAmmunitionAll(List<Ammunition> ammunitions) {
        List<Ammunition> alreadyEquipedAmmunition = new ArrayList<>();
        for (Ammunition ammunition : ammunitions) {
            Ammunition temp = addAmmunition(ammunition);
            if (temp != null) {
                alreadyEquipedAmmunition.add(temp);
            }
        }
        return alreadyEquipedAmmunition;
    }

    public List<Ammunition> getAmmunitions() {
        return ammunitions;
    }

    public Ammunition findEquipped(Ammunition ammunition) {
        for (Ammunition ammunition1 : ammunitions) {
            if (ammunition1.getAmmunitionType().equals(ammunition.getAmmunitionType())) {
                return ammunition1;
            }
        }
        return null;
    }

    public boolean isEquipped(Ammunition ammunition) {
        for (Ammunition ammunition1 : ammunitions) {
            if (ammunition1.getAmmunitionType().equals(ammunition.getAmmunitionType())) {
                return true;
            }
        }
        return false;
    }

    public Integer getPrice() {
        if (ammunitions.isEmpty()) {
            return 0;
        }
        Integer totalPrice = 0;
        for (Ammunition ammunition : ammunitions) {
            totalPrice += ammunition.getPrice();
        }
        return totalPrice;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name + "{" +
                "ammunitions = " + ammunitions +
                '}';
    }

}



