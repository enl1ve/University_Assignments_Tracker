package com.example.myapplication.model.Task.entity

import com.example.myapplication.Status
import com.example.myapplication.model.subjects.entity.Subject

data class Task(
    val id: Long,
    val title: String,
    val description: String,
    val status: Status,
    val rate: Int,
    val deadline: String,
    val subject: Subject
) {
    companion object {
        const val UNKNOWN_CREATED_AT = 0L
    }
}