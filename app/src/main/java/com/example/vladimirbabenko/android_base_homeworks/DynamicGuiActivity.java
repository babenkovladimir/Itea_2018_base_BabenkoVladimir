package com.example.vladimirbabenko.android_base_homeworks;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;


public class DynamicGuiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = getRootElement(this);

        root.addView(getMiddleLayout(this));
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

    private LinearLayout getMiddleLayout(Context context) {
        // Use ViewGroup.LayoutParams

        LinearLayout.LayoutParams middleLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        middleLayoutParams.weight = 12;
        middleLayoutParams.bottomMargin = 36;

        LinearLayout middleLayout = new LinearLayout(context);
        middleLayout.setOrientation(LinearLayout.VERTICAL);
        middleLayout.setLayoutParams(middleLayoutParams);


        //------------------Linear layout with lines----orLayout------
        LinearLayout.LayoutParams orParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 12f);
        orParams.bottomMargin = 5;

        LinearLayout orLayout = new LinearLayout(context);
        orLayout.setLayoutParams(orParams);
//        orLayout.setOrientation(LinearLayout.HORIZONTAL);


        //----------------------------------------------------
        View leftView = new View(context); // LeftView
        leftView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorWhite));


        LinearLayout.LayoutParams leftViewParams = new LinearLayout.LayoutParams(0, 1, 5f);

        leftView.setLayoutParams(leftViewParams);
        //----------------------------------------------------

        View rightView = new View(context); // RightView
        rightView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorWhite));


        LinearLayout.LayoutParams rightViewParams = new LinearLayout.LayoutParams(0, 1, 5f);
        rightViewParams.gravity= Gravity.CENTER;
        rightView.setLayoutParams(rightViewParams);
        //----------------------------------------------------
        TextView orTextView = new TextView(context); // TextView
        LinearLayout.LayoutParams orTextViewParams = (LinearLayout.LayoutParams) orTextView.getLayoutParams();
        //orTextViewParams.gravity = Gravity.CENTER;

        orTextView.setText("OR");
        orTextView.setTextColor(ContextCompat.getColor(this, R.color.colorWhite));
        orTextView.setTextSize(16);


        orLayout.addView(leftView);
        orLayout.addView(orTextView);
        orLayout.addView(rightView);
        //----------------------------------------------------


        middleLayout.addView(orLayout);

        return middleLayout;
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
        rightButtonParams.gravity = Gravity.END;

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
