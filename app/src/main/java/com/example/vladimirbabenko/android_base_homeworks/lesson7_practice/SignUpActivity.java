package com.example.vladimirbabenko.android_base_homeworks.lesson7_practice;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.OnClick;
import com.example.vladimirbabenko.android_base_homeworks.R;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.book_list_activity_mvp.BooksListActivity;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.entity.UserEntity;
import com.example.vladimirbabenko.android_base_homeworks.lesson8.base.BaseActivity;

public class SignUpActivity extends BaseActivity {

    @BindView(R.id.etEmailSignUpScreen) EditText etEmail;
    @BindView(R.id.etPasswordSignUpScreen) EditText etPassword;
    @BindView(R.id.etNameSignUpScreen) EditText etName;
    @BindView(R.id.etSecondNameSignUpScreen) EditText etSecondName;
    @BindView(R.id.btSignInSignUpScreen) Button btSignIn;

    @Override public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_sign_up);
        super.onCreate(savedInstanceState);
    }

    @OnClick(R.id.btSignInSignUpScreen) public void signInClick(View v) {
        boolean error = false;

        String email = etEmail.getText().toString();
        int password = Integer.valueOf(etPassword.getText().toString());
        String name = etName.getText().toString();
        String secondName = etSecondName.getText().toString();

        UserEntity userEntity = new UserEntity(email, password,name, secondName);
        Log.d(TAG, "signInClick Kotlin user: "+ userEntity.toString());


        if(!error){
            mDataManager.getPrefs().setUserChecked(true);
            saveToPreffs(email, password, name, secondName);
            startActivity(new Intent(this, BooksListActivity.class));
            finish();// void for delete activity from stack
        }
    }

    private void saveToPreffs(String email, int password, String name, String secondName){
        mDataManager.getPrefs().setUserEmail(email);
        mDataManager.getPrefs().setUserPassword(password);
        mDataManager.getPrefs().setUserName(name);
        mDataManager.getPrefs().setUserSecondName(secondName);
    }

}
