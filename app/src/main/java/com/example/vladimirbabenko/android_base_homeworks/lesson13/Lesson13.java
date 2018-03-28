package com.example.vladimirbabenko.android_base_homeworks.lesson13;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.example.vladimirbabenko.android_base_homeworks.R;

public class Lesson13 extends AppCompatActivity  implements View.OnClickListener{

    FragmentDinamic1 fragmentDinamic1;
    FragmentDinamic2 fragmentDinamic2;
    FragmentDinamic3 fragmentDinamic3;
    FrameLayout mFrameLayout;
    FragmentManager mFragmentManager;
    FragmentTransaction mTransaction;

    CheckBox mCheckBox;
    Button btAdd;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson13);



        fragmentDinamic1 = new FragmentDinamic1();
        fragmentDinamic2 = new FragmentDinamic2();
        fragmentDinamic3 = new FragmentDinamic3();

        mCheckBox = (CheckBox)findViewById(R.id.cbAddToBAckStack);
        mFrameLayout = (FrameLayout)findViewById(R.id.flFrame);
        mFragmentManager = getSupportFragmentManager();
        findViewById(R.id.btAdd).setOnClickListener(this);
        findViewById(R.id.btReplace).setOnClickListener(this);
        findViewById(R.id.btRemove).setOnClickListener(this);
        findViewById(R.id.btAttach).setOnClickListener(this);
        findViewById(R.id.btDetach).setOnClickListener(this);
        findViewById(R.id.btShow).setOnClickListener(this);
        findViewById(R.id.btHide).setOnClickListener(this);


    }

    @Override public void onClick(View v) {

        mTransaction = mFragmentManager.beginTransaction();
        switch (v.getId()){
            case R.id.btAdd:

                mTransaction.add(R.id.flFrame, fragmentDinamic1, "Fragment1");
                mTransaction.add(R.id.flFrame, fragmentDinamic2, "Fragment2");
                Toast.makeText(this, "Add", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btRemove:
                Toast.makeText(this, "Remove", Toast.LENGTH_SHORT).show();
                mTransaction.remove(fragmentDinamic2);
                break;

            case R.id.btReplace:
                mTransaction.replace(R.id.flFrame, fragmentDinamic3, "Fragment3");
                Toast.makeText(this, "Replace", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btHide:
                mTransaction.hide(fragmentDinamic1);
                Toast.makeText(this, "Add", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btShow:
                mTransaction.show(fragmentDinamic1);
                Toast.makeText(this, "Add", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btDetach:
                mTransaction.detach(fragmentDinamic1);
                Toast.makeText(this, "Add", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btAttach:
                Toast.makeText(this, "Add", Toast.LENGTH_SHORT).show();
                mTransaction.attach(fragmentDinamic1);
                break;
            default:break;

        }
        mTransaction.commit();
    }
}
