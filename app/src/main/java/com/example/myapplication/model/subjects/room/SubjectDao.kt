package com.example.myapplication.model.subjects.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.model.subjects.room.entitys.AccountSubjectSettingDB
import com.example.myapplication.model.subjects.room.entitys.SubjectDB
import kotlinx.coroutines.flow.Flow

@Dao
interface SubjectDao {
    @Query("SELECT * FROM subject LEFT JOIN account_subject_settings " +
            "ON subject.id = account_subject_settings.subject_id " +
            "AND account_subject_settings.account_id = :accountId")
    fun getSubject(accountId: Long): Flow<Map<SubjectDB, AccountSubjectSettingDB?>>

}