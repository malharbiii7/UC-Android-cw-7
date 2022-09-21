package com.example.rest;

import java.io.Serializable;

public class Salon implements Serializable {

    private String salonName;
    private double salonPrice;
    private String salonImg;

    public Salon() {
    }

    public Salon(String salonName, double salonPrice, String salonImg) {
        this.salonName = salonName;
        this.salonPrice = salonPrice;
        this.salonImg = salonImg;
    }

    public String getSalonName() {
        return salonName;
    }

    public void setSalonName(String salonName) {
        this.salonName = salonName;
    }

    public double getSalonPrice() {
        return salonPrice;
    }

    public void setSalonPrice(double salonPrice) {
        this.salonPrice = salonPrice;
    }

    public String getSalonImg() {
        return salonImg;
    }

    public void setSalonImg(String salonImg) {
        this.salonImg = salonImg;
    }
}
