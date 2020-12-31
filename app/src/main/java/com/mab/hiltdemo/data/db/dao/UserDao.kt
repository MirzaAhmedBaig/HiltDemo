package com.mab.hiltdemo.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.dewise.askus.data.db.entities.CURRENT_USER_ID
import com.dewise.askus.data.db.entities.User

@Dao
interface UserDao {
    @Insert
    suspend fun upsert(user: User)

    @Query("select * from User where uid = $CURRENT_USER_ID")
    fun getUser(): LiveData<User>

    @Update
    suspend fun updateUser(user: User)
}
