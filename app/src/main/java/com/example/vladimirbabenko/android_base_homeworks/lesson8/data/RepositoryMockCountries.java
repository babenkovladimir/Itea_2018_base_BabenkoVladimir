package com.example.vladimirbabenko.android_base_homeworks.lesson8.data;

import com.example.vladimirbabenko.android_base_homeworks.R;
import com.example.vladimirbabenko.android_base_homeworks.lesson5ClassMaterial.Country;
import java.util.ArrayList;
import java.util.List;

public class RepositoryMockCountries implements IRepositoryMock<Country> {

    public List<Country> fetchMocks() {
        List<Country> countries = new ArrayList<>();

        String[] countryNames = {
            "Киев", "Харьков", "Львов", "Ужгород", "Тернополь", "Коломия", "Хорватия", "Польша",
            "Америка", "Катя"
        };
        String[] countryCapitals = {
            "Киев-Center", "Харьков-Center", "Львов-Center", "Ужгород-Center", "Тернополь-Center",
            "Коломия-Center", "Хорватия-Center", "Польша-Center", "Америка-Center", "Катя-Center"
        };
        int[] pictures = {
            R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground
        };

        for(int i =0; i<countryNames.length; i++){
            countries.add(new Country(countryNames[i], countryCapitals[i], pictures[i]));
        }
        return countries;
    }
}
