package com.example.myapplication.model.User.entity

//Info about user

data class User (
    val id: Long,
    val email: String,
    val username: String
        ) {
    companion object {
        const val UNKNOWN_CREATED_AT = 0L
    }
}