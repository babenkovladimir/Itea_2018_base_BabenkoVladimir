package com.example.vladimirbabenko.android_base_homeworks;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.vladimirbabenko.android_base_homeworks.lesson4HomeWork.ColorPickerRezultActivity;


public class MainActivity extends AppCompatActivity {

    private Button btShowSignInActivity, btShowOtherTasks, btCustomUserViewActivity, btDynamicGui, btColorPicker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btShowSignInActivity = (Button) findViewById(R.id.btShowSignInActivity);
        btShowOtherTasks = (Button) findViewById(R.id.btShowOtherTasks);
        btCustomUserViewActivity = (Button) findViewById(R.id.btCustomUserView);
        btDynamicGui = (Button) findViewById(R.id.btDynamicGui);
        btColorPicker = (Button) findViewById(R.id.btColorPicker);


        btShowSignInActivity.setOnClickListener(
            view -> startActivity(new Intent(this, MainActivityHomeWorkScreen.class)));

        btShowOtherTasks.setOnClickListener(
            view -> startActivity(new Intent(this, OtherTaskActivity.class)));

        btCustomUserViewActivity.setOnClickListener(
            view -> startActivity(new Intent(this, CustomUserInfoActivity.class)));

        btDynamicGui.setOnClickListener(view -> startActivity(new Intent(this, DynamicGuiActivity.class)));

        btColorPicker.setOnClickListener(view -> startActivity(new Intent(this, ColorPickerRezultActivity.class)));

    }
}
