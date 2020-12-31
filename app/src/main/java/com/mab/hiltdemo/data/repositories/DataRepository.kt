package com.mab.hiltdemo.data.repositories

import com.dewise.askus.data.db.entities.User
import com.mab.hiltdemo.data.db.AppDatabase
import com.mab.hiltdemo.data.network.ApiManager
import javax.inject.Inject

class DataRepository @Inject constructor(
    private val apiManager: ApiManager,
    private val db: AppDatabase
) :
    BaseRepository() {

    suspend fun isUserExist(email: String) = safeApiCall { apiManager.isUserExist(email) }


    fun getUser() = db.getUserDao().getUser()
    suspend fun saveUser(user: User) = db.getUserDao().upsert(user)

}