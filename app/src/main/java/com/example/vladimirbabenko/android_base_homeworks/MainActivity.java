package com.example.vladimirbabenko.android_base_homeworks;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

/**
 * Created by VladimirBabenko on 2/17/2018.
 */

public class MainActivity extends AppCompatActivity {

    private Button btShowSignInActivity, btShowOtherTasks;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btShowSignInActivity = (Button) findViewById(R.id.btShowSignInActivity);
        btShowOtherTasks = (Button) findViewById(R.id.btShowOtherTasks);

        btShowSignInActivity.setOnClickListener(
            view -> startActivity(new Intent(this, MainActivityHomeWorkScreen.class)));

        btShowOtherTasks.setOnClickListener(
            view -> startActivity(new Intent(this, OtherTaskActivity.class)));
    }
}
