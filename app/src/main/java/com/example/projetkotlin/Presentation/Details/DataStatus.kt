package com.example.projetkotlin.Presentation.Details

sealed class DataStatus
object DataIsEmpty : DataStatus()
object DataSetIsNotEmpty : DataStatus()