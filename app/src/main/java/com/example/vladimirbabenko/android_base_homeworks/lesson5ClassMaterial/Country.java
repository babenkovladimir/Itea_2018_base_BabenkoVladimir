package com.example.vladimirbabenko.android_base_homeworks.lesson5ClassMaterial;

/**
 * Created by VladimirBabenko on 3/1/2018.
 */

public class Country {
    private String countryName;
    private String countryCapital;
    private int flag;

    public Country(String countryName, String countryCapital, int flag) {
        this.countryName = countryName;
        this.countryCapital = countryCapital;
        this.flag = flag;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCapital() {
        return countryCapital;
    }

    public void setCountryCapital(String countryCapital) {
        this.countryCapital = countryCapital;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
