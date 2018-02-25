package com.example.vladimirbabenko.android_base_homeworks.lesson4HomeWork;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.vladimirbabenko.android_base_homeworks.R;

public class ColorPickerActivity extends AppCompatActivity {

    private TextView tvRedRezult, tvGreenRezult, tvBlueRezult;
    private SeekBar sbRed, sbGreen, sbBlue;
    private int redProgress, greenProgress, blueProgress;
    private ImageView ivRezultView;
    private Button btSelect;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker);

        setupUI();
        setupListners();
        setupSeekBarValues();
        setupColor(128,128,128);
    }

    private void setupUI() {
        //tvRedRezult = (TextView)findViewById(R.id.tvRedRezult);
        //tvGreenRezult = (TextView)findViewById(R.id.tvGreenRezult);
        //tvBlueRezult = (TextView)findViewById(R.id.tvBlueRezult);

        // Works without casting
        tvRedRezult = findViewById(R.id.tvRedRezult);
        tvGreenRezult = findViewById(R.id.tvGreenRezult);
        tvBlueRezult = findViewById(R.id.tvBlueRezult);

        sbRed = (SeekBar) findViewById(R.id.sbRed);
        sbGreen = (SeekBar) findViewById(R.id.sbGreen);
        sbBlue = (SeekBar) findViewById(R.id.sbBlue);

        ivRezultView = (ImageView) findViewById(R.id.ivRezultView);

        btSelect = (Button) findViewById(R.id.btnSelect);
    }

    private void setupListners() {
        sbRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                redProgress = progress;
                tvRedRezult.setText(String.valueOf(redProgress));
                setupColor();
            }

            @Override public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        sbGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                greenProgress = progress;
                tvGreenRezult.setText(String.valueOf(greenProgress));
                setupColor();
            }

            @Override public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        sbBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                blueProgress = progress;
                tvBlueRezult.setText(String.valueOf(blueProgress));
                setupColor();
            }

            @Override public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        btSelect.setOnClickListener(v -> {

            Intent intent = new Intent();

            //Send information by simple extra
            intent.putExtra("r", redProgress);
            intent.putExtra("g", greenProgress);
            intent.putExtra("b", blueProgress);

            // Send information by bundle and parcelable object
            Bundle bundle = new Bundle();
            ColorObject colorRezult = new ColorObject(redProgress, greenProgress, blueProgress);
            bundle.putParcelable(Lesson4CodeList.COLOR_OBJECT_KEY, colorRezult);
            intent.putExtra(Lesson4CodeList.COLOR_BUNDLE_KEY, bundle);

            setResult(RESULT_OK, intent);
            finish();
        });
    }

    private void setupSeekBarValues() {
        redProgress = sbRed.getProgress();
        greenProgress = sbGreen.getProgress();
        blueProgress = sbBlue.getProgress();
    }

    private void setupColor() {
        int color = Color.rgb(redProgress, greenProgress, blueProgress);
        ivRezultView.setBackgroundColor(color);
    }

    private void setupColor(int r, int g, int b){
        int color = Color.rgb(r, g, b);
        ivRezultView.setBackgroundColor(color);

    }
}
