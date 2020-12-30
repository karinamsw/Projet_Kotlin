package com.example.projetkotlin.Details

sealed class DataStatus
object DataIsEmpty : DataStatus()
object DataSetIsNotEmpty : DataStatus()