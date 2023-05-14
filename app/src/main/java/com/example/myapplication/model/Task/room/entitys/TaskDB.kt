package com.example.myapplication.model.Task.room.entitys

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myapplication.Status
import com.example.myapplication.model.Task.entity.Task
import com.example.myapplication.model.subjects.entity.Subject

@Entity(
    tableName = "task"
)
data class TaskDB (
    @PrimaryKey val id: Long,
    val title: String,
    val description: String,
    val status: Status,
    val rate: Int,
    val deadline: String,
    val subject: Subject
){

    fun toTask() : Task = Task(
        id = id,
        title = title,
        description = description,
        status = status,
        rate = rate,
        deadline = deadline,
        subject = subject
    )
}