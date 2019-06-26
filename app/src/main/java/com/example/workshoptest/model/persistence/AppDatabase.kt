package com.example.workshoptest.model.persistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.workshoptest.model.entity.User


@Database(entities = arrayOf(User::class), version = 2)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao() : UserDao

}
