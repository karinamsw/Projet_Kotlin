package com.example.projetkotlin.Presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetkotlin.Domain.UseCase.CreateUserUseCase
import com.example.projetkotlin.Domain.UseCase.GetUserUseCase
import com.example.projetkotlin.Domain.entity.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(
    private val createUserUseCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase
) :ViewModel(){

   // val text: MutableLiveData<String> = MutableLiveData()
    val counter: MutableLiveData<Int> = MutableLiveData()

    init {
        //text.value = "Texte LiveData"
        counter.value = 0
    }

    fun onClickedIncrement(emailUser:String){
        viewModelScope.launch(Dispatchers.IO) {
            createUserUseCase.invoke((User("test")))
            delay(1000)
            val user: User = getUserUseCase.invoke("test")

        }


    }

}