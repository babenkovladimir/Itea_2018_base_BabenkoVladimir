package com.example.vladimirbabenko.android_base_homeworks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUI();
    }

    private void setupUI() {
        Button btGoogleSignIn = (Button) findViewById(R.id.btGoogleSignIn);
        Button btFacebookSignIn = (Button) findViewById(R.id.btFacebookSignIn);
        Button btLogin = (Button) findViewById(R.id.btLogin);
        Button btTerms = (Button) findViewById(R.id.btTerms);
        Button btSignUP = (Button) findViewById(R.id.btSignUp);

        EditText etLogin = (EditText) findViewById(R.id.etLogin);
        EditText etPassword = (EditText) findViewById(R.id.etPassword);

        btFacebookSignIn.setOnClickListener(
            view -> Toast.makeText(this, "SignIn by Facebook", Toast.LENGTH_SHORT).show());
        btGoogleSignIn.setOnClickListener(
            view -> Toast.makeText(this, "SignIn by Google", Toast.LENGTH_SHORT).show());

        btTerms.setOnClickListener(
            view -> Toast.makeText(this, "Show terms ", Toast.LENGTH_SHORT).show());
        btSignUP.setOnClickListener(
            view -> Toast.makeText(this, "SignUp is pressed", Toast.LENGTH_SHORT).show());

        btLogin.setOnClickListener(view -> {
            String password = String.valueOf(etPassword.getText());
        });
    }
}
