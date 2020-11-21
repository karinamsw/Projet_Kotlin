package com.example.projetkotlin.Data.Repository

import com.example.projetkotlin.Data.local.DatabaseDao
import com.example.projetkotlin.Data.local.models.UserLocal
import com.example.projetkotlin.Data.local.models.toData
import com.example.projetkotlin.Data.local.models.toEntity
import com.example.projetkotlin.Domain.entity.User

class UserRepository(
    private val databaseDao: DatabaseDao
){
    suspend fun createUser(user : User){
        databaseDao.insert(user.toData())

    }
    fun getUser(email:String): User {
        val userLocal:UserLocal = databaseDao.findByName(email)
        return userLocal.toEntity()
    }
}