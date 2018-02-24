package com.example.vladimirbabenko.android_base_homeworks.lesson4;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.vladimirbabenko.android_base_homeworks.R;

public class ColorPickerActivity extends AppCompatActivity {

    // Чтобы было красиво...
    private TextView tvSeekBarRedRezult, tvSeekBarGreenRezult, tvSeekBarBlueRezult;
    private TextView tvRedRezult, tvGreenRezult, tvBlueRezult;
    private SeekBar sbRed, sbGreen, sbBlue;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker);

        setupUI();
    }

    private void setupUI() {

        tvSeekBarRedRezult = (TextView) findViewById(R.id.tvSeekBarRedRezult);
        tvSeekBarGreenRezult = (TextView) findViewById(R.id.tvSeekBarGreenRezult);
        tvSeekBarBlueRezult = (TextView) findViewById(R.id.tvSeekBarBlueRezult);

        tvRedRezult = (TextView)findViewById(R.id.tvRedRezult);
        tvGreenRezult = (TextView)findViewById(R.id.tvGreenRezult);
        tvBlueRezult = (TextView)findViewById(R.id.tvBlueRezult);

        sbRed = (SeekBar)findViewById(R.id.sbRed);
        sbGreen = (SeekBar)findViewById(R.id.sbRed);
        sbBlue = (SeekBar)findViewById(R.id.sbRed);
    }
}
