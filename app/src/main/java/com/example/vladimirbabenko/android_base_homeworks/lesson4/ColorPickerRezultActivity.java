package com.example.vladimirbabenko.android_base_homeworks.lesson4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Button;
import android.widget.TextView;
import com.example.vladimirbabenko.android_base_homeworks.R;

public class ColorPickerRezultActivity extends AppCompatActivity {

    private TextView tvRedRezult, tvGreenRezult, tvBlueRezult;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker_rezult);

        setupUI();
    }

    private void setupUI() {

        tvRedRezult = (TextView) findViewById(R.id.tvRedRezult);
        tvGreenRezult = (TextView) findViewById(R.id.tvGreenRezult);
        tvBlueRezult = (TextView) findViewById(R.id.tvBlueRezult);

        Button btnOpenColorPicker = findViewById(R.id.btnOpenColorPicker);
        btnOpenColorPicker.setOnClickListener(
            v -> startActivity(new Intent(getApplicationContext(), ColorPickerActivity.class)));
    }
}