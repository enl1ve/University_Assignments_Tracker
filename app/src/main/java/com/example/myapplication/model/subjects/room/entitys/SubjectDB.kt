package com.example.myapplication.model.subjects.room.entitys

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myapplication.model.subjects.entity.Subject

@Entity(
    tableName = "subject"
)
data class SubjectDB (
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "teacher") val teacher: String,
    @ColumnInfo(name = "total_rate") val totalRate: Int,
        ){

    fun toSubject() : Subject = Subject(
        id = id,
        name = name,
        description = description,
        teacher = teacher,
        totalRate = totalRate
    )
}