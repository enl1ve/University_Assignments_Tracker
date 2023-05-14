package com.example.myapplication.model.User.room.entitys

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.myapplication.model.User.entity.SignUpData
import com.example.myapplication.model.User.entity.User

@Entity(
    tableName = "user",
    indices = [
        Index("email", unique = true)
    ])
data class UserDB (
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "email", collate = ColumnInfo.NOCASE) val email: String,
    val username: String,
    val password: String
        ){

    fun toUser() : User = User(
        id = id,
        email = email,
        username = username
    )

    companion object {
        fun formSignUpData(signUpData: SignUpData): UserDB = UserDB (
            id = 0,
            email = signUpData.email,
            username = signUpData.username,
            password = signUpData.password
                )
    }
}