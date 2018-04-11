package com.example.vladimirbabenko.android_base_homeworks.lesson7_practice

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.vladimirbabenko.android_base_homeworks.R
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.book_list_activity_mvp.BooksListActivity
import kotlinx.android.synthetic.main.activity_sign_up_kotlin.btSignInSignUpScreenKotlin
import kotlinx.android.synthetic.main.activity_sign_up_kotlin.etEmailSignUpScreenKotlin
import kotlinx.android.synthetic.main.activity_sign_up_kotlin.etNameSignUpScreenKotlin
import kotlinx.android.synthetic.main.activity_sign_up_kotlin.etPasswordSignUpScreenKotlin
import kotlinx.android.synthetic.main.activity_sign_up_kotlin.etSecondNameSignUpScreenKotlin

class SignUpActivityKotlin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_kotlin)

        setupUi()
    }

    fun setupUi():Unit{
        btSignInSignUpScreenKotlin.setOnClickListener({var error: Boolean = false

            var email: String = etEmailSignUpScreenKotlin.text.toString()
            var password: Int = etPasswordSignUpScreenKotlin.text.toString().toInt()
            var name: String = etNameSignUpScreenKotlin.text.toString()
            var secondName: String = etSecondNameSignUpScreenKotlin.text.toString()

            //if (!error) {

            val intent = Intent(applicationContext, BooksListActivity::class.java)
            startActivity(intent)
            finish()

        })
    }


}
