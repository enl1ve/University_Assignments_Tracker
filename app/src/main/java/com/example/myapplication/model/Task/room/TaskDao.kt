package com.example.myapplication.model.Task.room

import androidx.room.Query
import com.example.myapplication.model.Task.room.entitys.SubjectTaskSettingDB
import com.example.myapplication.model.Task.room.entitys.TaskDB
import kotlinx.coroutines.flow.Flow

interface TaskDao {
    @Query("SELECT * FROM task LEFT JOIN subject_task_settings " +
            "ON task.id = subject_task_settings.task_id " +
            "AND subject_task_settings.subject_id = :subjectId")
    fun getTask(subjectId: Long): Flow<Map<TaskDB, SubjectTaskSettingDB?>>
}