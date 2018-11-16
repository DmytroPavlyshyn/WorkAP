package com.pavlyshyn.ammunition;


public abstract class Ammunition {
    private final Integer id = 0;
    private Double weight;
    private Integer price;

    public Ammunition() {
    }

    public Ammunition(Double weight, Integer price) {
        this.weight = weight;
        this.price = price;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


    public Double getWeight() {
        return weight;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getId() {
        return id;
    }
    @Override
    public String toString() {
        return  this.getClass().getSimpleName()+" {" +
                //          "ammunitionKind=" + ammunitionKind +
                " weight=" + weight +
                ", price=" + price +
                "}";
    }
}

