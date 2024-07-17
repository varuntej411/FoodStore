package com.food.store.common

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow

val USER_ID = intPreferencesKey("user_id")
val USER_NAME = stringPreferencesKey("user_name")
val USER_SESSION = stringPreferencesKey("user_session")
val USER_LOGGEDIN = booleanPreferencesKey("user_logged_in")

interface UserDataStore {

    fun getUserId() : Flow<Int>
    suspend fun saveUserId(userId: Int)
    suspend fun deleteUserId()

    fun getUserName(): Flow<String>
    suspend fun saveUserName(userName: String)
    suspend fun deleteUserName()


    fun getSession(): Flow<String>
    suspend fun saveSession(userSession: String)
    suspend fun deleteSession()

    fun getUserLoggedIn(): Flow<Any>
    suspend fun saveUserLoggedIn(userLoggedIn: Boolean)
    suspend fun deleteUserLoggedIn()


}