package com.example.vladimirbabenko.android_base_homeworks.lesson7_practice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vladimirbabenko.android_base_homeworks.R;

public class LogoActivity extends AppCompatActivity {

    private EditText etName, etPassword;
    private Button btSignUp, btForgot, btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        setupUi();
    }

    private void setupUi() {
        etName = (EditText) findViewById(R.id.etName);
        etPassword = (EditText) findViewById(R.id.etPassword);

        btSignUp = (Button) findViewById(R.id.btSignUp);
        btForgot = (Button) findViewById(R.id.btForgot);
        btLogin = (Button) findViewById(R.id.btLogin);

        btSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "SignUp pressed", Toast.LENGTH_SHORT)
                    .show();
            }
        });
        btForgot.setOnClickListener(
            view -> Toast.makeText(getApplicationContext(), "Forgot is pressed", Toast.LENGTH_SHORT)
                .show());

        btLogin.setOnClickListener(view -> {
            boolean someError = false;

            if (etName.getText().toString().length() < 1) {
                etName.setError("is empty");
                someError = true;
            } else {
                etName.setError(null);
                someError = false;
            }

            if (etPassword.length() < 6) {
                etPassword.setError("passwort is short");
                someError = true;
            } else {
                etPassword.setError(null);
                someError=false;
            }

            if(!someError) startActivity(new Intent(getApplicationContext(), BooksListActivity.class));
        });
    }
}
