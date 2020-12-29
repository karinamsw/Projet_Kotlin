package com.example.projetkotlin.Presentation.main

sealed class LoginStatus

data class LoginSuccess(val email: String, val password: String) : LoginStatus()

object LoginErrorUser: LoginStatus()



