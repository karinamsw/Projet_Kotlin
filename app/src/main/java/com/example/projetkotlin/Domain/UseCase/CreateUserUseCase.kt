package com.example.projetkotlin.Domain.UseCase

import com.example.projetkotlin.Data.Repository.UserRepository
import com.example.projetkotlin.Domain.entity.User

class CreateUserUseCase(
    private val userRepository: UserRepository
) {
    suspend fun invoke (user : User){
        userRepository.createUser(user)

    }

}