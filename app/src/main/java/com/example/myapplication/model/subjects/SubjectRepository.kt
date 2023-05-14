package com.example.myapplication.model.subjects

import com.example.myapplication.model.User.entity.User
import com.example.myapplication.model.subjects.entity.Subject
import kotlinx.coroutines.flow.Flow

interface SubjectRepository {

    /**
     * Get the list of boxes.
     */
    suspend fun getSubject(): Flow<Subject?>

//    /**
//     * Mark the specified box as active. Only active boxes are displayed in dashboard screen.
//     * @throws StorageException
//     */
//    suspend fun activateSubject(subject: Subject)
//
//    /**
//     * Mark the specified box as inactive. Inactive boxes are not displayed in dashboard screen.
//     * @throws StorageException
//     */
//    suspend fun deactivateSubject(subject: Subject)

}