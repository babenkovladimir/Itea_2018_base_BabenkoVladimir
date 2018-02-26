package com.example.vladimirbabenko.android_base_homeworks;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;

public class DynamicGuiActivity extends AppCompatActivity {

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = getRootElement(this);

        root.addView(getUpperLayout(this));
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
        LinearLayout.LayoutParams middleLayoutParams =
            new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        middleLayoutParams.bottomMargin = 36;

        LinearLayout middleLayout = new LinearLayout(context);
        middleLayout.setOrientation(LinearLayout.VERTICAL);
        middleLayout.setLayoutParams(middleLayoutParams);

        //------------------Linear layout with lines----orLayout------
        LinearLayout.LayoutParams orParams =
            new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, 12f);
        orParams.bottomMargin = 5;

        LinearLayout orLayout = new LinearLayout(context);
        orLayout.setBaselineAligned(true);
        orLayout.setLayoutParams(orParams);
        //        orLayout.setOrientation(LinearLayout.HORIZONTAL);

        //----------------------------------------------------
        View leftView = new View(context); // LeftView
        leftView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorWhite));

        LinearLayout.LayoutParams leftViewParams = new LinearLayout.LayoutParams(0, 2, 5f);
        leftViewParams.gravity = Gravity.CENTER;

        //----------------------------------------------------

        View rightView = new View(context); // RightView
        rightView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorWhite));

        LinearLayout.LayoutParams rightViewParams = new LinearLayout.LayoutParams(0, 2, 5f);
        rightViewParams.gravity = Gravity.CENTER;
        rightView.setLayoutParams(rightViewParams);
        //----------------------------------------------------

        TextView orTextView = new TextView(context); // TextView

        LinearLayout.LayoutParams orTextViewParams =
            new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);


        orTextView.setText("OR");
        orTextView.setTextColor(ContextCompat.getColor(this, R.color.colorWhite));
        orTextView.setTextSize(16);



        orLayout.addView(leftView, leftViewParams);
        orLayout.addView(orTextView, orTextViewParams);
        orLayout.addView(rightView, rightViewParams); // add layouts to orLayout
        //----------------------------------------------------

        TextInputLayout loginTextInputLayout = new TextInputLayout(context);
        LinearLayout.LayoutParams loginTextInputLayoutParams = new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        TextInputEditText loginInputEditText = new TextInputEditText(context);
        TextInputLayout.LayoutParams loginInputEditTextParams = new TextInputLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        loginInputEditText.setCursorVisible(false);
        loginInputEditText.setHint(R.string.login);
        loginInputEditText.setTextColor(ContextCompat.getColor(context,R.color.colorWhite));


        loginTextInputLayout.addView(loginInputEditText, loginInputEditTextParams);


        middleLayout.addView(orLayout, orParams);
        middleLayout.addView(loginTextInputLayout, loginTextInputLayoutParams);

        return middleLayout;
    }

    private FrameLayout getLowerLayout(Context context) {
        FrameLayout flLowerLayout = new FrameLayout(context);

        // LayoutParams for LinearLayout
        FrameLayout.LayoutParams params =
            new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        Button btSignUp = new Button(context);
        btSignUp.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT));
        btSignUp.setText("sign Up");
        btSignUp.setTextSize(14);
        btSignUp.setTextColor(Color.WHITE);
        btSignUp.setPaddingRelative(1, 0, 1, 0);
        btSignUp.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);

        // LayoutParams for Button
        FrameLayout.LayoutParams rightButtonParams =
            new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        rightButtonParams.gravity = Gravity.END;

        Button btTerms = new Button(context);
        btTerms.setLayoutParams(rightButtonParams);
        btTerms.setText(R.string.trms);
        btTerms.setTextSize(14);
        btTerms.setGravity(Gravity.END);
        btTerms.setTextColor(Color.WHITE);
        btTerms.setPaddingRelative(1, 0, 1, 0);
        btTerms.setGravity(Gravity.END | Gravity.CENTER_VERTICAL);

        flLowerLayout.addView(btSignUp);// Params by setLayoutParams
        flLowerLayout.addView(btTerms, rightButtonParams);// Params in void addView

        return flLowerLayout;
    }

    private LinearLayout getUpperLayout(Context context) {
        LinearLayout.LayoutParams upperLayoutParams =
            new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        upperLayoutParams.bottomMargin = 20;

        LinearLayout upperLayout = new LinearLayout(context);
        upperLayout.setOrientation(LinearLayout.VERTICAL);
        upperLayout.setLayoutParams(upperLayoutParams);

        //---------------------------------------------
        TextView tvHelloAgain = new TextView(context);  // TextView Hellow againe

        LinearLayout.LayoutParams tvHelloAgainParams =
            new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        tvHelloAgainParams.gravity = Gravity.CENTER;

        tvHelloAgain.setLayoutParams(tvHelloAgainParams);
        tvHelloAgain.setText(R.string.hellow_agein);
        tvHelloAgain.setTextSize(20);
        tvHelloAgain.setTextColor(ContextCompat.getColor(context, R.color.colorWhite));

        //---------------------------------------------
        TextView tvSignUpBy = new TextView(context);  // TextView signUoBy

        LinearLayout.LayoutParams tvSignUpByParams =
            new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        tvSignUpByParams.gravity = Gravity.START;

        tvSignUpBy.setLayoutParams(tvSignUpByParams);
        tvSignUpBy.setText(R.string.sign_in_using);
        tvSignUpBy.setTextSize(14);
        tvSignUpBy.setTextColor(ContextCompat.getColor(context, R.color.colorWhite));
        tvSignUpBy.setGravity(Gravity.START);

        //------------------LinearLayout Sign_In_Buttons

        LinearLayout.LayoutParams llSignInButtonsParams =
            new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, 11f);

        LinearLayout llSignInButtons = new LinearLayout(context);
        llSignInButtonsParams.weight = 11;
        llSignInButtonsParams.topMargin = 5;
        llSignInButtons.setLayoutParams(llSignInButtonsParams);

        Button btGoogleSignIn = new Button(context);//Button google auth
        btGoogleSignIn.setBackgroundColor(ContextCompat.getColor(context, R.color.colorGoogleRed));


        Button btFacebookSignIn = new Button(context);// Button FaceBookAuth
        btFacebookSignIn.setBackgroundColor(ContextCompat.getColor(context, R.color.colorFacebookBlue));
        Space space = new Space(context);//Space betveen buttons

        LinearLayout.LayoutParams googleParams =
            new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 150, 5f);

        LinearLayout.LayoutParams spaceParams =
            new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, 1f);

        LinearLayout.LayoutParams facebookParams =
            new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 150, 5f);

        llSignInButtons.addView(btGoogleSignIn, googleParams);
        llSignInButtons.addView(space, spaceParams);
        llSignInButtons.addView(btFacebookSignIn, facebookParams);
        //------------------------------------------------
        upperLayout.addView(tvHelloAgain);
        upperLayout.addView(tvSignUpBy);
        upperLayout.addView(llSignInButtons);

        return upperLayout;
    }
}
