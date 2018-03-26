package com.example.vladimirbabenko.android_base_homeworks.lesson12;


import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.vladimirbabenko.android_base_homeworks.R;

public class DialogFragmentActivity extends AppCompatActivity {

    public TestDialogFragment mTestDialogFragment;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_fragment);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        TestDialogFragment.newInstance(null).show(ft, "TestDialogFragment");

        //getSupportFragmentManager().fi




    }



}
