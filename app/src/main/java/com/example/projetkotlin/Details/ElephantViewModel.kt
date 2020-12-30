package com.example.projetkotlin.Details

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetkotlin.Data.API.ElephantApi
import com.example.projetkotlin.Domain.entity.Elephant
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ElephantViewModel : ViewModel() {

    val eleph : MutableLiveData<List<Elephant>> = MutableLiveData()
    val apiCallResul : MutableLiveData<ApiCallStatus> = MutableLiveData()
    val dataStatus : MutableLiveData<DataStatus> = MutableLiveData()


    fun onStart(context: Context) {
        eleph.value = getDataFromCache(context)
        val DataStatus = if (eleph.value != null) {
            DataSetIsNotEmpty
        } else {
            DataIsEmpty
        }
        dataStatus.value = DataStatus
    }

     fun makeApiCall() {
         val baseUrl: String = "https://raw.githubusercontent.com/karinamsw/PtojetAndroid/master/"

         val gson = GsonBuilder()
             .setLenient()
             .create()

         val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val elephantApi = retrofit.create(ElephantApi::class.java)

        val call: Call<RestElephantResponse> = elephantApi.getElephantResponse()
        call.enqueue(object : Callback<RestElephantResponse> {
            override fun onResponse(
                call: Call<RestElephantResponse>,
                response: Response<RestElephantResponse>
            ) {
                if (response.isSuccessful() && response.body() != null) {
                    eleph.value = response.body()!!.getResults()
                   apiCallResul.value = ApiCallSuccess
                    Log.i("apical", "success")
                    //Toast.makeText(getApplicationContext(), "API Success", Toast.LENGTH_SHORT).show();
                } else {
                    apiCallResul.value = ApiCallError
                    Log.i("apical", "error")
                }
            }

            override fun onFailure(call: Call<RestElephantResponse>, t: Throwable) {
                apiCallResul.value = ApiCallError
                Log.i("apical", "fail")
            }
        })
    }

    fun saveList(list: List<Elephant>, context: Context) {
        val gson : Gson = GsonBuilder().setLenient().create()
        val json: String = gson.toJson(list)

        val sharedPreferences =  context.getSharedPreferences("jsonElephantList", Context.MODE_PRIVATE)
        val editor = sharedPreferences
            .edit()
            .putString("jsonElephantList", json)
            editor.commit()
    }


    fun showList(list : List<Elephant>, recyclerView: RecyclerView, layoutManager: LinearLayoutManager){

        viewModelScope.launch(Dispatchers.IO){

            var adapter = ListAdapter(list)
            recyclerView.adapter = adapter
        }


    }


    fun getDataFromCache(context : Context): List<Elephant>? {

        val gson : Gson= Gson()
        val list : List<Elephant>
        val sharedPreference =  context.getSharedPreferences("jsonElephantList",Context.MODE_PRIVATE)
        val jsonElephant = sharedPreference.getString("jsonElephantList",null)
        val typeElephant = object : TypeToken<List<Elephant>>(){}.type


       if (jsonElephant != null) {

            list = gson.fromJson(jsonElephant, typeElephant)
           return list
        }
        return null
    }


}