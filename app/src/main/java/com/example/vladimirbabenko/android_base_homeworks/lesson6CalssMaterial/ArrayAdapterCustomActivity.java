package com.example.vladimirbabenko.android_base_homeworks.lesson6CalssMaterial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.vladimirbabenko.android_base_homeworks.R;


import java.util.ArrayList;
import java.util.List;

import static android.content.Intent.ACTION_VIEW;

public class ArrayAdapterCustomActivity extends AppCompatActivity {

    private static String[] countryNames = {"Киев", "Харьков", "Львов", "Ужгород", "Тернополь", "Коломия", "Хорватия", "Польша",
        "Америка", "Катя"};
    private static String[] countryCapitals = {"Киев-Center", "Харьков-Center", "Львов-Center", "Ужгород-Center", "Тернополь-Center", "Коломия-Center", "Хорватия-Center", "Польша-Center",
        "Америка-Center", "Катя-Center"};
    private static int[] pictures = {R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground};

    private List<CountryLess6> countryList;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adapter_custom);
        listView = (ListView)findViewById(R.id.lvCustomCountryList);



        countryList=getContries();
        CustomArrayAdapter customAdapter = new CustomArrayAdapter(getApplicationContext(), R.layout.item_layout_custom, countryList);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
            }
        });
    }

    private ArrayList<CountryLess6> getContries(){

        ArrayList<CountryLess6> countryList = new ArrayList<>();
        for(int i =0; i<countryNames.length; i++){
            countryList.add(new CountryLess6(countryNames[i], countryCapitals[i], pictures[i]));
        }
        return countryList;
    }
}
