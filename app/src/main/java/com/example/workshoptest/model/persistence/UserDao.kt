package com.example.workshoptest.model.persistence

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.workshoptest.model.entity.User

@Dao
interface UserDao {
    @Insert
    fun inserAll(users : User): Long

    @Query("SELECT * FROM user")
    fun getAll () : List<User>
}