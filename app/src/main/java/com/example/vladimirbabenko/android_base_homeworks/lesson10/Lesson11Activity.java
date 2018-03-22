package com.example.vladimirbabenko.android_base_homeworks.lesson10;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.vladimirbabenko.android_base_homeworks.R;

public class Lesson11Activity extends AppCompatActivity {

    String APP_PREFERENCES = "APP_PREFERENCES";// Ключ к ящику в шаред преференсес

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson11);

        SharedPreferences mySharedPreferences = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = mySharedPreferences.edit();
        editor.putString("t", "temp");
        editor.apply();
    }
}
