package com.example.projetkotlin.Presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetkotlin.Domain.UseCase.CreateUserUseCase
import com.example.projetkotlin.Domain.UseCase.GetUserUseCase
import com.example.projetkotlin.Domain.entity.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Suppress("IMPLICIT_CAST_TO_ANY")
class MainViewModel(
    private val createUserUseCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase
) :ViewModel(){

    val loginLiveData: MutableLiveData<LoginStatus> = MutableLiveData()
    val createData: MutableLiveData<createStatus> = MutableLiveData()



    fun onClickedLogin(emailUser: String, password: String){
            viewModelScope.launch(Dispatchers.IO) {
                val user = getUserUseCase.invoke(emailUser, password)
                val loginStatus = if (user != null) {
                        LoginSuccess(user.email, user.password)
                }else {

                    LoginErrorUser
                }

                withContext(Dispatchers.Main) {
                    loginLiveData.value = loginStatus
                }
            }
        }





    fun onClickedCreate(emailUser: String, password: String){
        viewModelScope.launch(Dispatchers.IO) {
            val user = getUserUseCase.invoke(emailUser, password)
            val createStatus = if (user == null) {
                createSuccess(emailUser)

            }else {
                createError
            }

            if (createStatus == createSuccess(emailUser)){
                createUserUseCase.invoke(User(emailUser,password))
            }

            withContext(Dispatchers.Main) {
                createData.value = createStatus
            }
        }
    }


    }

