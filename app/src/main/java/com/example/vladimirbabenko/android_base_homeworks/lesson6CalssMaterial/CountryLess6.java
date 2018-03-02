package com.example.vladimirbabenko.android_base_homeworks.lesson6CalssMaterial;

/**
 * Created by VladimirBabenko on 3/1/2018.
 */

public class CountryLess6 {
    private String countryName;
    private String countryCapital;
    private int flag;

    public CountryLess6(String countryName, String countryCapital, int flag) {
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
