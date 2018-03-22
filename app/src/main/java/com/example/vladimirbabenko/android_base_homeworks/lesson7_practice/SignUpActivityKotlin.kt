package com.example.vladimirbabenko.android_base_homeworks.lesson7_practice

import android.content.Intent
import android.os.Bundle
import android.view.View
import butterknife.OnClick
import com.example.vladimirbabenko.android_base_homeworks.R
import com.example.vladimirbabenko.android_base_homeworks.lesson8.base.BaseActivity
import kotlinx.android.synthetic.main.activity_sign_up_kotlin.etEmailSignUpScreenKotlin
import kotlinx.android.synthetic.main.activity_sign_up_kotlin.etNameSignUpScreenKotlin
import kotlinx.android.synthetic.main.activity_sign_up_kotlin.etPasswordSignUpScreenKotlin
import kotlinx.android.synthetic.main.activity_sign_up_kotlin.etSecondNameSignUpScreenKotlin

class SignUpActivityKotlin : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_sign_up_kotlin)
        super.onCreate(savedInstanceState)
    }
// Doesn't work
    @OnClick(R.id.btSignInSignUpScreenKotlin) fun btSignUpOnClick(view: View): Unit {
        var error: Boolean = false

        var email: String = etEmailSignUpScreenKotlin.text.toString()
        var password: Int = etPasswordSignUpScreenKotlin.text.toString().toInt()
        var name: String = etNameSignUpScreenKotlin.text.toString()
        var secondName: String = etSecondNameSignUpScreenKotlin.text.toString()

        //if (!error) {

        val intent = Intent(applicationContext, BooksListActivity::class.java)
        startActivity(intent)
        finish()
        // }
    }

}
