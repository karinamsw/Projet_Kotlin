package com.example.projetkotlin.Presentation.Register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetkotlin.Domain.UseCase.CreateUserUseCase
import com.example.projetkotlin.Domain.UseCase.GetUserUseCase
import com.example.projetkotlin.Domain.entity.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegisterViewModel (
    private val createUserUseCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel(){
    val createData: MutableLiveData<createStatus> = MutableLiveData()


    fun onClickedCreate(emailUser: String, password: String){
        viewModelScope.launch(Dispatchers.IO) {
            val user = getUserUseCase.invoke(emailUser, password)
            val createStatus = if (user == null) {
                createSuccess(
                    emailUser
                )

            }else {
                createError
            }

            if (createStatus == createSuccess(
                    emailUser
                )
            ){
                createUserUseCase.invoke(User(emailUser,password))
            }

            withContext(Dispatchers.Main) {
                createData.value = createStatus
            }
        }
    }



}


