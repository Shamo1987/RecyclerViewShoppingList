package com.info.recyclerviewshoppinglist;



public class Movies {
    private String movName;
    private double price;
    private String picture;

    public Movies() {
    }

    public Movies(String movName, double price, String picture) {
        this.movName = movName;
        this.price = price;
        this.picture = picture;
    }

    public String getMovName() {
        return movName;
    }

    public void setMovName(String movName) {
        this.movName = movName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
