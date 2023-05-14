package com.example.myapplication.model.User.room

import android.accounts.Account
import android.database.sqlite.SQLiteConstraintException
import android.database.sqlite.SQLiteException
import com.example.myapplication.AccountAlreadyExistsException
import com.example.myapplication.AuthException
import com.example.myapplication.EmptyFieldException
import com.example.myapplication.Field
import com.example.myapplication.model.Settings.AppSettings
import com.example.myapplication.model.User.UserRepository
import com.example.myapplication.model.User.entity.SignUpData
import com.example.myapplication.model.User.entity.User
import com.example.myapplication.model.User.room.entitys.AccountUpdateUsernameTuple
import com.example.myapplication.model.User.room.entitys.UserDB
import com.example.myapplication.model.room.wrapSQLiteException
import com.example.myapplication.utils.AsyncLoader
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class RoomUserRepository(
    private val userDao: UserDao,
    private val appSettings: AppSettings,
    private val ioDispatcher: CoroutineDispatcher
) : UserRepository {

    private val currentAccountIdFlow = AsyncLoader {
        MutableStateFlow(AccountId(appSettings.getCurrentAccountId()))
    }

    override suspend fun isSignedIn(): Boolean {
        delay(2000)
        return appSettings.getCurrentAccountId() != AppSettings.NO_ACCOUNT_ID
    }

    override suspend fun signIn(email: String, password: String) = wrapSQLiteException(ioDispatcher) {
        if (email.isBlank()) throw EmptyFieldException(Field.Email)
        if (password.isBlank()) throw EmptyFieldException(Field.Password)

        delay(1000)

        val accountId = findAccountIdByEmailAndPassword(email, password)
        appSettings.setCurrentAccountId(accountId)
        currentAccountIdFlow.get().value = AccountId(accountId)

        return@wrapSQLiteException
    }

    override suspend fun signUp(signUpData: SignUpData) = wrapSQLiteException(ioDispatcher) {
        signUpData.validate()
        delay(1000)
        createAccount(signUpData)
    }

    override suspend fun logout() {
        appSettings.setCurrentAccountId(AppSettings.NO_ACCOUNT_ID)
        currentAccountIdFlow.get().value = AccountId(AppSettings.NO_ACCOUNT_ID)
    }

    override suspend fun getAccount(): Flow<User?> {
        return currentAccountIdFlow.get()
            .flatMapLatest { accountId ->
                if (accountId.value == AppSettings.NO_ACCOUNT_ID) {
                    flowOf(null)
                } else {
                    getAccountById(accountId.value)
                }
            }
            .flowOn(ioDispatcher)
    }

    override suspend fun updateAccountUsername(newUsername: String) = wrapSQLiteException(ioDispatcher) {
        if (newUsername.isBlank()) throw EmptyFieldException(Field.Username)
        delay(1000)
        val accountId = appSettings.getCurrentAccountId()
        if (accountId == AppSettings.NO_ACCOUNT_ID) throw AuthException()

        updateUsernameForAccountId(accountId, newUsername)

        currentAccountIdFlow.get().value = AccountId(accountId)
        return@wrapSQLiteException
    }

    private suspend fun findAccountIdByEmailAndPassword(email: String, password: String): Long {
        val tuple = userDao.findByEmail(email) ?: throw AuthException()
        if (tuple.password != password) throw AuthException()
        return tuple.id
    }

    private suspend fun createAccount(signUpData: SignUpData) {
        try {
            val entity = UserDB.formSignUpData(signUpData)
            userDao.createUser(entity)
        } catch (e: SQLiteConstraintException) {
            val appException = AccountAlreadyExistsException()
            appException.initCause(e)
            throw appException
        }
    }

    private fun getAccountById(accountId: Long): Flow<User?> {
        return userDao.getById(accountId).map { UserDB -> UserDB?.toUser() }
    }

    private suspend fun updateUsernameForAccountId(accountId: Long, newUsername: String) {
        userDao.updateUsername(
            AccountUpdateUsernameTuple(accountId, newUsername)
        )
    }

    private class AccountId(val value: Long)

}