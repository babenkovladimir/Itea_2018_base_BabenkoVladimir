package com.example.vladimirbabenko.android_base_homeworks.lesson4HomeWork;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.vladimirbabenko.android_base_homeworks.R;

public class ColorPickerRezultActivity extends AppCompatActivity {

    private TextView tvRedRezult, tvGreenRezult, tvBlueRezult;
    private ImageView ivRezultViewRez;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker_rezult);

        setupUI();
        setupColor(128, 128, 128);
    }

    private void setupUI() {

        tvRedRezult = (TextView) findViewById(R.id.tvRedRezult);
        tvGreenRezult = (TextView) findViewById(R.id.tvGreenRezult);
        tvBlueRezult = (TextView) findViewById(R.id.tvBlueRezult);
        ivRezultViewRez = (ImageView) findViewById(R.id.ivRezultViewRez);

        Button btnOpenColorPicker = findViewById(R.id.btnOpenColorPicker);
        btnOpenColorPicker.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                //
                //Intent intent = new Intent(getApplicationContext(), ColorPickerActivity.class);


                //implicit call
                Intent intent = new Intent("itea.base.lesson4.colorPicker");

                startActivityForResult(intent, Lesson4CodeList.COLOR_PICKER_REQUEST_CODE);
            }
        });
    }

    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //----------------Get information by bundle and parcelable object
        parceByBundle(requestCode, resultCode, data);
        //----------------Get information by simple extras
        //parceBySimpleExtars(requestCode, resultCode, data);
    }

    private void parceByBundle(int requestCode, int resultCode, Intent data) {
        if (requestCode == Lesson4CodeList.COLOR_PICKER_REQUEST_CODE && resultCode == RESULT_OK) {
            Bundle bundle = data.getBundleExtra(Lesson4CodeList.COLOR_BUNDLE_KEY);
            if(bundle!=null && bundle.containsKey(Lesson4CodeList.COLOR_OBJECT_KEY)){
                ColorObject colorObject =
                    (ColorObject) bundle.get(Lesson4CodeList.COLOR_OBJECT_KEY);
                int r = colorObject.getRed();
                int g = colorObject.getGreen();
                int b = colorObject.getBlue();

                tvRedRezult.setText(String.valueOf(r));
                tvGreenRezult.setText(String.valueOf(g));
                tvBlueRezult.setText(String.valueOf(b));
                setupColor(r, g, b);
            }
        }
    }

    private void parceBySimpleExtars(int requestCode, int resultCode, Intent data) {
        int r=0;
        int g=0;
        int b=0;

        if (requestCode == Lesson4CodeList.COLOR_PICKER_REQUEST_CODE && resultCode == RESULT_OK && data!=null) {
            Bundle extras = data.getExtras();
            if (extras.containsKey("r")) r=extras.getInt("r");
            if (extras.containsKey("g")) g=extras.getInt("g");
            if (extras.containsKey("b")) b=extras.getInt("b");
        }
        setupColor(r,g,b);
    }

    private void setupColor(int r, int g, int b) {
        ivRezultViewRez.setBackgroundColor(Color.rgb(r, g, b));
    }
}