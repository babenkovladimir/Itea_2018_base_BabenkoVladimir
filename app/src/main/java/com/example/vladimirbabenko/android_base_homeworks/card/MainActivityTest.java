package com.example.vladimirbabenko.android_base_homeworks.card;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivityTest extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);

        //LinearLayout.LayoutParams = new LinearLayout.LayoutParams();

        Button bt1 = new Button(this);
        bt1.setText("Button1");
        bt1.setWidth(100);


        root.addView(bt1);


        setContentView(root);
    }
}
