package com.example.projetkotlin.Data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.projetkotlin.Data.local.models.UserLocal

@Dao
interface DatabaseDao {
    @Query("SELECT * FROM userlocal")
    fun getAll(): List<UserLocal>

    @Query("SELECT * FROM userLocal WHERE email LIKE :email LIMIT 1")
    fun findByName(email: String): UserLocal

    @Insert
    fun insert(user: UserLocal)

    @Delete
    fun delete(user: UserLocal)
}