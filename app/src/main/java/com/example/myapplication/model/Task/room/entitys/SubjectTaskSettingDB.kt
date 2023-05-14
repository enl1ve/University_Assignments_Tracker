package com.example.myapplication.model.Task.room.entitys

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import com.example.myapplication.model.subjects.room.entitys.SubjectDB

@Entity(
    tableName = "subject_task_settings",
    primaryKeys = ["subject_id", "task_id"],
    indices = [
        Index("subject_id")
    ],
    foreignKeys = [
        ForeignKey(
            entity = SubjectDB::class,
            parentColumns = ["id"],
            childColumns = ["subject_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = TaskDB::class,
            parentColumns = ["id"],
            childColumns = ["task_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class SubjectTaskSettingDB (
    @ColumnInfo(name = "task_id") val taskId: Long,
    @ColumnInfo(name = "subject_id") val subjectId: Long,
        ){
}