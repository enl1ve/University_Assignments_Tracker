package com.example.myapplication.model.subjects.room

import com.example.myapplication.AuthException
import com.example.myapplication.model.Settings.AppSettings
import com.example.myapplication.model.User.UserRepository
import com.example.myapplication.model.room.wrapSQLiteException
import com.example.myapplication.model.subjects.SubjectRepository
import com.example.myapplication.model.subjects.entity.Subject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapLatest

class RoomSubjectRepository (
    private val userRepository: UserRepository,
    private val subjectDao: SubjectDao,
    private val ioDispatcher: CoroutineDispatcher
) //: SubjectRepository
{
//
//    override suspend fun getSubject(): Flow<Subject?> {
//        return Subject.get()
//            .flatMapLatest { subject ->
//                if (subject.value == AppSettings.NO_ACCOUNT_ID) {
//                    flowOf(null)
//                } else {
//                    return null
//                }
//            }
//            .flowOn(ioDispatcher)
//    }

}