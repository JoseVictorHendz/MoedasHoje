package com.example.ramonsl.moedashoje;

import java.io.Serializable;

/**
 * Created by ramonsl on 15/05/2018.
 */

public class Stocks implements Serializable {

    private String nName;
    private String nLocation;
    private double nVariation;


    public String getName() {
        return nName;
    }

    public void setName(String nName) {
        this.nName = nName;
    }

    public String getLocation() {
        return nLocation;
    }

    public void setLocation(String nLocation) {
        this.nLocation = nLocation;
    }

    public String getVariation() {
        return String.valueOf(nVariation);
    }

    public void setVariation(double nVariation) {
        this.nVariation = nVariation;
    }

    public Stocks(String nName, String nLocation, double nVariation) {
        this.nName = nName;
        this.nLocation = nLocation;
        this.nVariation = nVariation;
    }

    @Override
    public String toString() {
        return "Stocks{" +
                "nName='" + nName + '\'' +
                '}';
    }
}
