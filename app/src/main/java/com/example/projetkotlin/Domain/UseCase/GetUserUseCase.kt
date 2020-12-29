package com.example.projetkotlin.Domain.UseCase

import com.example.projetkotlin.Data.Repository.UserRepository
import com.example.projetkotlin.Domain.entity.User

class GetUserUseCase(
    private val userRepository: UserRepository
){
    suspend fun invoke (email:String):User? {
        return userRepository.getUser(email)
    }
}