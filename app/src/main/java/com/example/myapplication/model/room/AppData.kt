package com.example.myapplication.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.model.User.room.UserDao
import com.example.myapplication.model.User.room.entitys.UserDB
import com.example.myapplication.model.subjects.room.SubjectDao
import com.example.myapplication.model.subjects.room.entitys.AccountSubjectSettingDB
import com.example.myapplication.model.subjects.room.entitys.SubjectDB

@Database(
    version = 1,
    entities = [
        UserDB::class,
        SubjectDB::class,
        AccountSubjectSettingDB::class
    ])
abstract class AppData : RoomDatabase() {
    abstract fun getUserDao(): UserDao

    abstract fun getSubjectDao(): SubjectDao
}