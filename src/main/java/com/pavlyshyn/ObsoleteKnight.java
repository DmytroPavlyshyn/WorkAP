package com.pavlyshyn;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.pavlyshyn.ammunition.*;

import java.io.File;

public class ObsoleteKnight {
    private String name;
    private Helmet helmet = new Helmet();
    private Armour armour = new Armour();
    private ElbowPads elbowPads = new ElbowPads();
    private ChainMail chainMail = new ChainMail();
    private Gloves gloves = new Gloves();
    private IronKneePads ironKneePads = new IronKneePads();
    private Sword sword = new Sword();
    private Shield shield = new Shield();

    public ObsoleteKnight() {
    }

    public ObsoleteKnight(String name, Helmet helmet, Armour armour, ElbowPads elbowPads, ChainMail chainMail, Gloves gloves, IronKneePads ironKneePads, Sword sword, Shield shield) {
        this.name = name;
        this.helmet = helmet;
        this.armour = armour;
        this.elbowPads = elbowPads;
        this.chainMail = chainMail;
        this.gloves = gloves;
        this.ironKneePads = ironKneePads;
        this.sword = sword;
        this.shield = shield;
    }

    public ObsoleteKnight(String name) {
        this.name = name;
    }

    public ObsoleteKnight setHelmet(Double weight, Integer price) {
        this.helmet.setWeight(weight);
        this.helmet.setPrice(price);
        return this;
    }

    public ObsoleteKnight setArmour(Double weight, Integer price) {
        this.armour.setWeight(weight);
        this.armour.setPrice(price);
        return this;
    }

    public ObsoleteKnight setElbowPads(Double weight, Integer price) {
        this.elbowPads.setWeight(weight);
        this.elbowPads.setPrice(price);
        return this;
    }

    public ObsoleteKnight setChainMail(Double weight, Integer price) {
        this.chainMail.setWeight(weight);
        this.chainMail.setPrice(price);
        return this;
    }

    public ObsoleteKnight setGloves(Double weight, Integer price) {
        this.gloves.setWeight(weight);
        this.gloves.setPrice(price);
        return this;
    }

    public ObsoleteKnight setIronKneePads(Double weight, Integer price) {
        this.ironKneePads.setWeight(weight);
        this.ironKneePads.setPrice(price);
        return this;
    }

    public ObsoleteKnight setSword(Double weight, Integer price) {
        this.sword.setWeight(weight);
        this.sword.setPrice(price);
        return this;
    }

    public ObsoleteKnight setShield(Double weight, Integer price) {
        this.shield.setWeight(weight);
        this.shield.setPrice(price);
        return this;
    }

    public String getName() {
        return name;
    }

    public Ammunition getHelmet() {
        return helmet;
    }

    public Ammunition getArmour() {
        return armour;
    }

    public Ammunition getElbowPads() {
        return elbowPads;
    }

    public Ammunition getChainMail() {
        return chainMail;
    }

    public Ammunition getGloves() {
        return gloves;
    }

    public Ammunition getIronKneePads() {
        return ironKneePads;
    }

    public Ammunition getSword() {
        return sword;
    }

    public Ammunition getShield() {
        return shield;
    }

    @Override
    public String toString() {
        return "ObsoleteKnight{" +
                "name='" + name + '\'' +
                ", helmet=" + helmet +
                ", armour=" + armour +
                ", elbowPads=" + elbowPads +
                ", chainMail=" + chainMail +
                ", gloves=" + gloves +
                ", ironKneePads=" + ironKneePads +
                ", sword=" + sword +
                ", "+this.getShield().getClass().getSimpleName()+"=" + shield +
                '}';
    }

    public static void main(String[] args) {

        ObsoleteKnight obsoleteKnight; //= new ObsoleteKnight("Jack");
//        obsoleteKnight.setHelmet(1.0,2)
//                .setArmour(2.0,3)
//                .setElbowPads(3.0,12)
//                .setChainMail(1.0,1)
//                .setGloves(2.0,1)
//                .setIronKneePads(2.0,4)
//                .setSword(4.0,12)
//                .setShield(2.0,13);
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            obsoleteKnight = objectMapper.readValue(new File("456.json"), ObsoleteKnight.class);
            //   objectMapper.writeValue(new File("456.json"),obsoleteKnight);
            //   ObsoleteKnight obsoleteKnight = objectMapper.readValue(new File("456.json"),ObsoleteKnight.class);
            System.out.println(obsoleteKnight);
        }catch (Exception e){
            System.err.println(e);
        }

    }
}
