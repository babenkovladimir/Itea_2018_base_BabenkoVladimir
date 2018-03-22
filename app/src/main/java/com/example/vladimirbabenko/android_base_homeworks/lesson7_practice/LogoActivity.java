package com.example.vladimirbabenko.android_base_homeworks.lesson7_practice;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import com.example.vladimirbabenko.android_base_homeworks.R;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.utils.BooksConstants;
import com.example.vladimirbabenko.android_base_homeworks.lesson8.base.BaseActivity;

public class LogoActivity extends BaseActivity {

    @BindView(R.id.etName) EditText etName;
    @BindView(R.id.etPassword) EditText etPassword;
    @BindView(R.id.btSignUp) Button btSignUp;
    @BindView(R.id.btForgot) Button btForgot;
    @BindView(R.id.btLogin) Button btLogin;
    @BindView(R.id.cbRemember) CheckBox cbRemember;


    private Boolean someError = true;

    @Override public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_logo);
        super.onCreate(savedInstanceState);
    }

    private void setupUi() {

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
                someError = false;
            }

            if (!someError) {
                startActivity(new Intent(getApplicationContext(), BooksListActivity.class));
            }
        });
    }

    @OnClick(R.id.btSignUp) public void btSignUpClick(View v) {
        startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
        finish();
    }

    @OnClick(R.id.btForgot) public void btForgotUpClick(View v) {
        Toast.makeText(getApplicationContext(), "Forgot is pressed", Toast.LENGTH_SHORT).show();
    }

    @OnTextChanged(value = R.id.etPassword, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    public void passwordCheck(Editable s) {
        if (etPassword.length() < 6) {
            etPassword.setError("passwort is short");
            someError = true;
        } else {
            etPassword.setError(null);
            someError = false;
        }
    }

    @OnTextChanged(value = R.id.etName) public void emailCheck() {
        if (etName.getText().toString().length() < 1) {
            etName.setError("is empty");
            someError = true;
        } else {
            etName.setError(null);
            someError = false;
        }
    }

    @OnClick(R.id.btLogin) public void btLoginClick() {
        if (!someError) {
            mDataManager.getPrefs().setUserChecked(cbRemember.isChecked());
            startActivity(new Intent(getApplicationContext(), BooksListActivity.class));
            finish();// чтобы нельзя было вернуться на кактивити
        }
    }
}
