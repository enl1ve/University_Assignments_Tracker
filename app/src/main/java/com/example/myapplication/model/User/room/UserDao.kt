package com.example.myapplication.model.User.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.myapplication.model.User.room.entitys.AccountSignInTuple
import com.example.myapplication.model.User.room.entitys.AccountUpdateUsernameTuple
import com.example.myapplication.model.User.room.entitys.UserDB
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT id, password FROM user WHERE email = :email")
    suspend fun findByEmail(email: String) : AccountSignInTuple?

    @Update(entity = UserDB::class)
    suspend fun updateUsername(updateUsernameTuple: AccountUpdateUsernameTuple)

    @Insert
    suspend fun createUser(userDB: UserDB)

    @Query("SELECT * FROM user WHERE id = :userId")
    fun getById(userId: Long): Flow<UserDB?>
}