package com.example.projetkotlin.Details

import com.example.projetkotlin.Domain.entity.Elephant

class RestElephantResponse {
    private val Results: List<Elephant>? = null


    fun getResults(): List<Elephant>? {
        return Results
    }
}