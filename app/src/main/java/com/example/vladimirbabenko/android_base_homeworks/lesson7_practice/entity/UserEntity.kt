package com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.entity

data class UserEntity(val email:String,val password:Integer, val name:String,val secondName:String){

    override fun toString(): String {
        return "My Kotlin data class!!! UserEntity email:$email, password:$password, name: $name, secondName:$secondName  "
    }
}