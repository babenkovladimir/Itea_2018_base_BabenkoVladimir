package com.example.vladimirbabenko.android_base_homeworks;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/**
 * Created by VladimirBabenko on 2/21/2018.
 */

public class DynamicGuiActivity extends AppCompatActivity {

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = getRootElement(this);

        root.addView(getLowerLayout(this));

        setContentView(root);
    }

    private LinearLayout getRootElement(Context context) {

        LinearLayout.LayoutParams rootParams =
            new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);

        LinearLayout root = new LinearLayout(context);
        root.setLayoutParams(rootParams);
        root.setOrientation(LinearLayout.VERTICAL);

        root.setPaddingRelative(24, 0, 24, 0);
        root.setGravity(Gravity.BOTTOM);
        //root.setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent));// - it works
        root.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.background1));

        return root;
    }

    private FrameLayout getLowerLayout(Context context) {
        FrameLayout flLowerLayout = new FrameLayout(context);

        // LayoutParams for LinearLayout
        FrameLayout.LayoutParams params =
            new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);




        Button btSignUp = new Button(context);
        btSignUp.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        btSignUp.setText("sign Up");
        btSignUp.setTextSize(14);
        btSignUp.setTextColor(Color.WHITE);
        btSignUp.setPaddingRelative(1, 0, 1, 0);
        btSignUp.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);

        // LayoutParams for Button
        FrameLayout.LayoutParams rightButtonParams = new FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rightButtonParams.gravity=Gravity.END;

        Button btTerms = new Button(context);
        btTerms.setLayoutParams(rightButtonParams);
        btTerms.setText("Terms");
        btTerms.setTextSize(14);
        btTerms.setGravity(Gravity.END);
        btTerms.setTextColor(Color.WHITE);
        btTerms.setPaddingRelative(1, 0, 1, 0);
        btTerms.setGravity(Gravity.END | Gravity.CENTER_VERTICAL);

        flLowerLayout.addView(btSignUp);// Params by setLayoutParams
        flLowerLayout.addView(btTerms, rightButtonParams);// Params in void addView

        return flLowerLayout;
    }
}
