package com.example.projetkotlin.Presentation.Register

sealed class createStatus

data class createSuccess(val email: String) : createStatus()
object createError: createStatus()
