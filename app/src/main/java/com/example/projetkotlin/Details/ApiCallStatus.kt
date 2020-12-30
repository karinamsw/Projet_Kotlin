package com.example.projetkotlin.Details

sealed class ApiCallStatus
object ApiCallSuccess : ApiCallStatus()
object ApiCallError : ApiCallStatus()