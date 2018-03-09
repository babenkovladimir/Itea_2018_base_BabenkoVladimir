package com.example.vladimirbabenko.android_base_homeworks.lesson8.data;

import com.example.vladimirbabenko.android_base_homeworks.lesson5ClassMaterial.Country;
import java.util.List;

public class DataManager {

    RepositoryMockCountries mRepositoryMockCountries;

    public DataManager() {
        mRepositoryMockCountries = new RepositoryMockCountries();
    }

    // специально в названии нету названия fetchMocksCountries(){
    public List<Country> fetchMocks() {
        return mRepositoryMockCountries.fetchMocks();
    }
}
