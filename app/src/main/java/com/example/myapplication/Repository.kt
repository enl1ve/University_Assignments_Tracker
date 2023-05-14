package com.example.myapplication

import android.content.Context
import androidx.room.Room
import com.example.myapplication.model.Settings.AppSettings
import com.example.myapplication.model.Settings.SharedPreferencesAppSettings
import com.example.myapplication.model.User.UserRepository
import com.example.myapplication.model.User.room.RoomUserRepository
import com.example.myapplication.model.room.AppData
import com.example.myapplication.model.subjects.SubjectRepository
import com.example.myapplication.model.subjects.room.RoomSubjectRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

object Repositories {

    private lateinit var applicationContext: Context

    // -- stuffs

    private val database: AppData by lazy<AppData> {
        Room.databaseBuilder(applicationContext, AppData::class.java, "database.db")
            .createFromAsset("initial_database.db")
            .build()
    }

    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO

    private val appSettings: AppSettings by lazy {
        SharedPreferencesAppSettings(applicationContext)
    }

    // --- repositories

    val accountsRepository: UserRepository by lazy {
        RoomUserRepository(database.getUserDao(), appSettings, ioDispatcher)
    }

    val subjectRepository: SubjectRepository by lazy {
        RoomSubjectRepository(accountsRepository, database.getSubjectDao(), ioDispatcher)
    }

    /**
     * Call this method in all application components that may be created at app startup/restoring
     * (e.g. in onCreate of activities and services)
     */
    fun init(context: Context) {
        applicationContext = context
    }
}