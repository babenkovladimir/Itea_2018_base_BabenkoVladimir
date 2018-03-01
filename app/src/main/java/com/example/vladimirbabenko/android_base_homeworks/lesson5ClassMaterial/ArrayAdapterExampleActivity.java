package com.example.vladimirbabenko.android_base_homeworks.lesson5ClassMaterial;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;

import android.widget.TextView;
import com.example.vladimirbabenko.android_base_homeworks.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ArrayAdapterExampleActivity extends AppCompatActivity {
    private static String TAG = "tag";
    //private static String[] countryArray = {
    //    "Киев", "Харьков", "Львов", "Ужгород", "Тернополь", "Коломия", "Хорватия", "Польша",
    //    "Америка", "Катя", "Оля", "Петя", "Марина", "Артём", "Киев", "Харьков", "Львов", "Ужгород",
    //    "Тернополь", "Коломия", "Хорватия", "Польша", "Америка", "Катя", "Оля", "Петя", "Марина",
    //    "Артём", "Киев", "Харьков", "Львов", "Ужгород", "Тернополь", "Коломия", "Хорватия",
    //    "Польша", "Америка", "Катя", "Оля", "Петя", "Марина", "Артём", "Киев", "Харьков", "Львов",
    //    "Ужгород", "Тернополь", "Коломия", "Хорватия", "Польша", "Америка", "Катя", "Оля", "Петя",
    //    "Марина", "Артём"
    //};

    private static String[] countryArray = {
        "Киев", "Харьков", "Львов", "Ужгород", "Тернополь", "Коломия", "Хорватия", "Польша",
        "Америка", "Катя"
    };

    private static String[] capitalNames = {
        "Киев-centr", "Харьков-centr", "Львов-centr", "Ужгород-centr", "Тернополь-centr",
        "Коломия-centr", "Хорватия-centr", "Польша-centr", "Америка-centr", "Катя-centr"
    };

    private static int[] flags = {
        R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_background, R.drawable.ic_launcher_background
    };

    //List<String> countryList;
    List<Country> listCountry;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adapter_example);
        Log.d(TAG, "onCreate: ");

        listCountry = new ArrayList<Country>();

        for (int i = 0; i < countryArray.length; i++) {
            listCountry.add(new Country(countryArray[i], capitalNames[i], flags[i]));
        }

        // countryList = new ArrayList<String>(Arrays.asList(countryArray));

        //ArrayAdapter<String> adapter =
        //    new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,
        //        countryList);
        CustomAdapter customAdapter =
            new CustomAdapter(getApplicationContext(), R.layout.item_layout_custom, listCountry);
        ListView listView = (ListView) findViewById(R.id.lvCountryList);
        //listView.setAdapter(adapter);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);

                Uri uri = Uri.parse("https://ru.wikipedia.org/wiki/" + listCountry.get(position).getCountryCapital());
                intent.setData(uri);
                getApplicationContext().startActivity(intent);
            }
        });

        //Button btAddListItem = (Button) findViewById(R.id.btAddListItem);
        //btAddListItem.setOnClickListener(v -> {
        //    countryList.add(String.valueOf(new Random().nextInt(10)));
        //    adapter.notifyDataSetChanged();
        //});
        //Button btRemoveSomeItem = (Button) findViewById(R.id.btRemoveSomeItem);
        //btRemoveSomeItem.setOnClickListener(v -> {
        //    countryList.remove(new Random().nextInt(countryList.size()));
        //    adapter.notifyDataSetChanged();
        //});
    }

    @Override protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: ");
    }

    @Override protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState: ");
    }
}
