package com.example.myapplication.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.model.User.room.UserDao
import com.example.myapplication.model.User.room.entitys.UserDB

@Database(
    version = 1,
    entities = [
        UserDB::class
    ])
abstract class AppData : RoomDatabase() {
    abstract fun getUserDao(): UserDao
}