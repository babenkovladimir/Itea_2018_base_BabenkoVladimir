package com.example.vladimirbabenko.android_base_homeworks.card;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.example.vladimirbabenko.android_base_homeworks.R;

public class DynamicGuiActivityOld extends AppCompatActivity {

    @Override public void onCreate(@Nullable Bundle savedInstanceState,
        @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

      //  LinearLayout root = new LinearLayout(this);
      //  root.setOrientation(LinearLayout.VERTICAL);
      //
      //
      //
      //  //LinearLayout.LayoutParams rootParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
      //  //    ViewGroup.LayoutParams.MATCH_PARENT);
      //  //
      //  //root.setBackgroundColor(ContextCompat.getColor(this, R.color.ColorPink));
      //
      //  Button bt1 = new Button(this);
      //  bt1.setText("Кнопка!");
      //
      //  root.addView(bt1);
      ////  setContentView(root, rootParams);
      //  setContentView(root);


        LinearLayout root = new LinearLayout(this);

        //LinearLayout.LayoutParams = new LinearLayout.LayoutParams();

        Button bt1 = new Button(this);
        bt1.setText("Button1");
        bt1.setWidth(100);


        root.addView(bt1);


        setContentView(root);


        //FrameLayout flLowerLayout = getLowerLayout(this);








        //root.addView(flLowerLayout);
        //setContentView(root);
    }

    private LinearLayout getRootElement(Context context) {
        LinearLayout.LayoutParams rootParams =
            new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);

        LinearLayout root = new LinearLayout(context);
        root.setLayoutParams(rootParams);


        root.setBackgroundColor(Color.BLUE);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPaddingRelative(24, 0, 24, 0);
        root.setGravity(Gravity.BOTTOM);
        root.setBackgroundColor(ContextCompat.getColor(this,R.color.colorAccent));

        return root;
    }

    private FrameLayout getLowerLayout(Context context) {
        FrameLayout flLowerLayout = new FrameLayout(context);
        flLowerLayout.setLayoutParams(
            new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));


        Button btSignUp = new Button(context);
        btSignUp.setId(Integer.parseInt("@+id/btSignUp"));
        btSignUp.setText("sign Up");
        btSignUp.setTextSize(14);
        btSignUp.setTextColor(Color.WHITE);
        btSignUp.setPaddingRelative(1,0,1,0);
        btSignUp.setGravity(Gravity.LEFT|Gravity.CENTER_VERTICAL);







        flLowerLayout.addView(btSignUp);

        return flLowerLayout;
    }
}
