package com.example.myapplication.model.subjects.room.entitys

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import com.example.myapplication.model.User.room.entitys.UserDB

@Entity(
    tableName = "account_subject_settings",
    primaryKeys = ["account_id", "subject_id"],
    indices = [
        Index("subject_id")
    ],
    foreignKeys = [
        ForeignKey(
            entity = UserDB::class,
            parentColumns = ["id"],
            childColumns = ["user_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        ),
    ForeignKey(
            entity = SubjectDB::class,
            parentColumns = ["id"],
            childColumns = ["subject_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
    )
    ]
)
data class AccountSubjectSettingDB (
    @ColumnInfo(name = "account_id") val userId: Long,
    @ColumnInfo(name = "subject_id") val subjectId: Long,
        ){
}