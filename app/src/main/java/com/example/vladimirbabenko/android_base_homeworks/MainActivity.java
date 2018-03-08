package com.example.vladimirbabenko.android_base_homeworks;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.vladimirbabenko.android_base_homeworks.lesson4ClassMaterial.IntentExampleActivity;
import com.example.vladimirbabenko.android_base_homeworks.lesson4HomeWork.ColorPickerRezultActivity;
import com.example.vladimirbabenko.android_base_homeworks.lesson5ClassMaterial.ArrayAdapterExampleActivity;
import com.example.vladimirbabenko.android_base_homeworks.lesson6CalssMaterial.ArrayAdapterCustomActivity;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.BooksListActivity;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.LogoActivity;

public class MainActivity extends AppCompatActivity {

    private Button btShowSignInActivity, btShowOtherTasks, btCustomUserViewActivity, btDynamicGui,
        btColorPicker, btImplicitCalls, btArrayAdapterAndLifecycle, bCustomArrayAdapter, btLesson7Practice;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btShowSignInActivity = (Button) findViewById(R.id.btShowSignInActivity);
        btShowOtherTasks = (Button) findViewById(R.id.btShowOtherTasks);
        btCustomUserViewActivity = (Button) findViewById(R.id.btCustomUserView);
        btDynamicGui = (Button) findViewById(R.id.btDynamicGui);
        btColorPicker = (Button) findViewById(R.id.btColorPicker);
        btImplicitCalls = (Button) findViewById(R.id.btImplicitCalls);
        btArrayAdapterAndLifecycle = (Button) findViewById(R.id.btArrayAdapterAndLifecycle);
        bCustomArrayAdapter = (Button) findViewById(R.id.bCustomArrayAdapter);
        btLesson7Practice = (Button) findViewById(R.id.btLesson7Practice);

        btShowSignInActivity.setOnClickListener(
            view -> startActivity(new Intent(this, MainActivityHomeWorkScreen.class)));

        btShowOtherTasks.setOnClickListener(
            view -> startActivity(new Intent(this, OtherTaskActivity.class)));

        btCustomUserViewActivity.setOnClickListener(
            view -> startActivity(new Intent(this, CustomUserInfoActivity.class)));

        btDynamicGui.setOnClickListener(
            view -> startActivity(new Intent(this, DynamicGuiActivity.class)));

        btColorPicker.setOnClickListener(
            view -> startActivity(new Intent(this, ColorPickerRezultActivity.class)));

        btImplicitCalls.setOnClickListener(view -> startActivity(
            new Intent(getApplicationContext(), IntentExampleActivity.class)));
        btArrayAdapterAndLifecycle.setOnClickListener(view -> startActivity(new Intent(this, ArrayAdapterExampleActivity.class)));

        bCustomArrayAdapter.setOnClickListener(view-> startActivity(new Intent(this, ArrayAdapterCustomActivity.class)));

        btLesson7Practice.setOnClickListener(view-> startActivity(new Intent(this, LogoActivity.class)));

    }
}
