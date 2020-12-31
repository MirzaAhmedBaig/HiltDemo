package com.mab.hiltdemo.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mab.hiltdemo.data.db.dao.UserDao
import com.dewise.askus.data.db.entities.User
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Database(
    entities = [User::class],
    version = DBConstants.DB_VERSION
)

abstract class AppDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao
}