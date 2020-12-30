package com.example.projetkotlin.Data.API

import com.example.projetkotlin.Details.RestElephantResponse
import com.example.projetkotlin.Domain.entity.Elephant
import retrofit2.Call
import retrofit2.http.GET

interface ElephantApi {

    @GET("ElephantApi.json")
    fun getElephantResponse(): Call<RestElephantResponse>

}
