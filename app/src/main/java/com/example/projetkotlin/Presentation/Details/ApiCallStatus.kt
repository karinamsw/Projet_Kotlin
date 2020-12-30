package com.example.projetkotlin.Presentation.Details

sealed class ApiCallStatus
object ApiCallSuccess : ApiCallStatus()
object ApiCallError : ApiCallStatus()