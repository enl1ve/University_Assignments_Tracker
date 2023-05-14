package com.example.myapplication.model.User.entity

import com.example.myapplication.EmptyFieldException
import com.example.myapplication.Field
import com.example.myapplication.PasswordMismatchException

data class SignUpData (
    val username: String,
    val email: String,
    val password: String,
    val repeatPassword: String
        ){
    fun validate() {
        if (email.isBlank()) throw EmptyFieldException(Field.Email)
        if (username.isBlank()) throw EmptyFieldException(Field.Username)
        if (password.isBlank()) throw EmptyFieldException(Field.Password)
        if (password != repeatPassword) throw PasswordMismatchException()
    }
}