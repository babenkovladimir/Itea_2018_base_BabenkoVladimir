package com.example.vladimirbabenko.android_base_homeworks.card;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.vladimirbabenko.android_base_homeworks.R;
import com.squareup.picasso.Picasso;

public class DynamicGuiActivity extends AppCompatActivity {

    @Override public void onCreate(@Nullable Bundle savedInstanceState,
        @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        LinearLayout root = getRootElement(this);

        setContentView(root, null);
    }

    private LinearLayout getRootElement(Context context) {

        LinearLayout root = new LinearLayout(context);
        LinearLayout.LayoutParams rootParams =
            new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);

        root.setOrientation(LinearLayout.VERTICAL);
        root.setPaddingRelative(24, 0, 24, 0);
        root.setGravity(Gravity.BOTTOM);
        root.setBackground(getResources().getDrawable(R.drawable.background1));

        return root;
    }

    private FrameLayout getLowerLayout(Context context) {
        FrameLayout flLowerLayout = new FrameLayout(context);

        Button btSignUp = new Button(context);
        btSignUp.setId(Integer.parseInt("@+id/btSignUp"));

        return flLowerLayout;
    }
}
