package com.example.ramonsl.moedashoje;

import java.io.Serializable;

public class Stocks implements Serializable {

    private String sName;
    private String sLocation;
    private String sVariation;

    public Stocks(String sName, String sLocation, String sVariation) {
        this.sName = sName;
        this.sLocation = sLocation; // buy
        this.sVariation = sVariation;
    }

    public String getName() {
        return sName;
    }

    public String getLocation() {
        return "Localização "+ sLocation.toString();
    }

    public String getVariation() {

        return sVariation.toString();
    }
}
