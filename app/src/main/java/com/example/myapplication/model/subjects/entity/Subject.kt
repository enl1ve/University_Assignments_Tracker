package com.example.myapplication.model.subjects.entity

data class Subject (
    val id: Long,
    val name: String,
    val description: String,
    val teacher: String,
    val totalRate: Int
        ){

    companion object {
        const val UNKNOWN_CREATED_AT = 0L
    }

}