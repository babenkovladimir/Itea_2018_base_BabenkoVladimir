package com.example.vladimirbabenko.android_base_homeworks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        /*
        * Email validation
        *
        * */

        btLogin.setOnClickListener(view -> {
            String email = String.valueOf(etLogin.getText());
            String password = String.valueOf(etLogin.getText());

            if(password.length()<8) Toast.makeText(this, "password is very short", Toast.LENGTH_SHORT).show();

            if (isValidEmail(email)) {
                Toast.makeText(this, "Email is valid", Toast.LENGTH_SHORT).show();
            } else {
                etLogin.setError("Wrong login");
            }

        });
    }

    //&& isValidPassword(password)

    private boolean isValidEmail(CharSequence email) {
        if (email == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }
    }
    private boolean isValidPassword(CharSequence password) {
        String regEx = "[0-9]+";

        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }
}
