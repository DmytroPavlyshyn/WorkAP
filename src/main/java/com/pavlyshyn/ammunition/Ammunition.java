package com.pavlyshyn.ammunition;


public class Ammunition {
    private AmmunitionType ammunitionType;
    private AmmunitionQuality ammunitionQuality;
    private Double weight;
    private Integer price;

    public Ammunition() {
    }

    public Ammunition(AmmunitionType ammunitionType, AmmunitionQuality ammunitionQuality, Double weight, Integer price) {
        this.ammunitionType = ammunitionType;
        this.ammunitionQuality = ammunitionQuality;
        this.weight = weight;
        this.price = price;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
    public void setAmmunitionType(AmmunitionType ammunitionType) {
        this.ammunitionType = ammunitionType;
    }
    public void setAmmutionType(String ammutionType) {
        this.ammunitionType = AmmunitionType.valueOf(ammutionType);
    }

    public void setAmmunitionQuality(AmmunitionQuality ammunitionQuality) {
        this.ammunitionQuality = ammunitionQuality;
    }
    public void setAmmunitionQuality(String ammunitionQuality) {
        this.ammunitionQuality = AmmunitionQuality.valueOf(ammunitionQuality);
    }
    public Double getWeight() {
        return weight;
    }

    public Integer getPrice() {
        return price;
    }

    public String getAmmunitionType() {
        return ammunitionType.toString();
    }

    public AmmunitionQuality getAmmunitionQuality() {
        return ammunitionQuality;
    }

    @Override
    public String toString() {
        return "\n"+ ammunitionType + " {"+
                ", \n\tquality=" + ammunitionQuality +
                ", \n\tweight=" + weight +
                ", \n\tprice=" + price +
                '}';
    }
}

