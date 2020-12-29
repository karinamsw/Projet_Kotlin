package com.example.projetkotlin.Details

import android.content.SharedPreferences
import android.util.Log
import com.example.projetkotlin.Data.API.ElephantApi
import com.example.projetkotlin.Presentation.main.MainActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainController {
/*
    private var sharedPreferences: SharedPreferences? = null
    private var gson: Gson? = null
    private var view: DetailsViewModel? = null

    fun MainController(
        detailsViewModel : DetailsViewModel?,
        gson: Gson?,
        sharedPreferences: SharedPreferences?
    ) {
        view = detailsViewModel
        this.gson = gson
        this.sharedPreferences = sharedPreferences
    }

    fun onStart() {
        val elephantList: List<Elephant>? = getDataFromCache()
        if (elephantList != null) {
            view.showList(elephantList)
        } else {
            makeApiCall()
        }
    }

    private fun makeApiCall() {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        val elephantApi: ElephantApi = retrofit.create<ElephantApi>(ElephantApi::class.java)
        Log.d("VINCE", "BEFORE CALLBACK")
        val call: Call<RestElephantResponse> = elephantApi.getElephantResponse()
        call.enqueue(object : Callback<RestElephantResponse?> {
            override fun onResponse(
                call: Call<RestElephantResponse?>,
                response: Response<RestElephantResponse?>
            ) {
                Log.d("VINCE", "INSIDE CALLBACK")
                if (response.isSuccessful() && response.body() != null) {
                    val elephantList: List<Elephant> =
                        response.body().getResults()
                    saveList(elephantList)
                    view.showList(elephantList)
                    //Toast.makeText(getApplicationContext(), "API Success", Toast.LENGTH_SHORT).show();
                } else {
                    view.showError()
                }
            }

            override fun onFailure(
                call: Call<RestElephantResponse?>,
                t: Throwable
            ) {
                view.showError()
            }
        })
    }

    private fun saveList(elephantList: List<Elephant>) {
        val jsonString = gson!!.toJson(elephantList)
        sharedPreferences
            .edit()
            .putString(Constants.KEY_ELEPHANT_LIST, jsonString)
            .apply()
    }


    private fun getDataFromCache(): List<Elephant>? {
        val jsonElephant =
            sharedPreferences!!.getString(Constants.KEY_ELEPHANT_LIST, null)
        return if (jsonElephant == null) {
            null
        } else {
            val listType =
                object : TypeToken<List<Elephant?>?>() {}.type
            gson!!.fromJson<List<Elephant>>(jsonElephant, listType)
        }
    }


    fun onItemClick(elephant: Elephant?) {
        view.navigateToDetails(elephant)
    }
*/
}