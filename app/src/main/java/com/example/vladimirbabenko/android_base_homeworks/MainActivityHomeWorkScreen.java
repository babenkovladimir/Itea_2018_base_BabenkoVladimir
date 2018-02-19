package com.example.vladimirbabenko.android_base_homeworks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityHomeWorkScreen extends AppCompatActivity {

    private EditText etLogin, etPassword;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home_screen);

        setupUI();
    }

    private void setupUI() {
        Button btGoogleSignIn = (Button) findViewById(R.id.btGoogleSignIn);
        Button btFacebookSignIn = (Button) findViewById(R.id.btFacebookSignIn);
        Button btLogin = (Button) findViewById(R.id.btLogin);
        Button btTerms = (Button) findViewById(R.id.btTerms);
        Button btSignUP = (Button) findViewById(R.id.btSignUp);

        TextView tvFogotPassword = (TextView) findViewById(R.id.tvFogotPassword);

        etLogin = (EditText) findViewById(R.id.etLogin);
        etPassword = (EditText) findViewById(R.id.etPassword);

        tvFogotPassword.setOnClickListener(view -> {
            etLogin.setText("");
            etLogin.setError(null);
            etPassword.setText("");
            etPassword.setError(null);
        });

        btFacebookSignIn.setOnClickListener(
            view -> Toast.makeText(this, "SignIn by Facebook", Toast.LENGTH_SHORT).show());
        btGoogleSignIn.setOnClickListener(
            view -> Toast.makeText(this, "SignIn by Google", Toast.LENGTH_SHORT).show());

        btTerms.setOnClickListener(
            view -> Toast.makeText(this, "Show terms ", Toast.LENGTH_SHORT).show());
        btSignUP.setOnClickListener(
            view -> Toast.makeText(this, "SignUp is pressed", Toast.LENGTH_SHORT).show());

        btLogin.setOnClickListener(view -> {
            String email = String.valueOf(etLogin.getText());
            String password = String.valueOf(etPassword.getText());
            boolean isPasswordValid = false;
            boolean isEmailValid = false;

            if (password.length() < 8) etPassword.setError(getString(R.string.password_ahort));
             else isPasswordValid = true;


            if (isValidEmail(email)) isEmailValid = true;
            else  etLogin.setError("Wrong password");


            if (isEmailValid && isPasswordValid)
                Toast.makeText(this,"Succesful", Toast.LENGTH_SHORT).show();

        });
    }

    //&& isValidPassword(password)

    private boolean isValidEmail(CharSequence email) {
        return email != null && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

}
