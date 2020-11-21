package com.example.projetkotlin.Data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.projetkotlin.Data.local.models.UserLocal

@Database(entities = arrayOf(UserLocal::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun DatabaseDao(): DatabaseDao
}