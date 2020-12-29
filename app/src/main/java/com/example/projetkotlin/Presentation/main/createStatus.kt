package com.example.projetkotlin.Presentation.main

sealed class createStatus

data class createSuccess(val email: String) : createStatus()
object createError: createStatus()
