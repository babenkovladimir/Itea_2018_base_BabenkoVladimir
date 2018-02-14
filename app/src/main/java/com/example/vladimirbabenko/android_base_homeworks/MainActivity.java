package com.example.vladimirbabenko.android_base_homeworks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btA, btB;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUI();
    }

    private void setupUI() {
        btA = findViewById(R.id.btA);
        btB = findViewById(R.id.btB);

        btA.setOnClickListener(view -> btA.setText(
            btA.getText().equals(R.string.btn_1) ? R.string.btn_2 : R.string.btn_1));
        btB.setOnClickListener(
            view -> btB.setText(new Random().nextBoolean() ? R.string.btn_2 : R.string.btn_1));
    }
}
