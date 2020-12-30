package com.example.projetkotlin.injection

import android.content.Context
import androidx.room.Room
import com.example.projetkotlin.Data.Repository.UserRepository
import com.example.projetkotlin.Data.local.AppDatabase
import com.example.projetkotlin.Data.local.DatabaseDao
import com.example.projetkotlin.Presentation.Details.ElephantViewModel
import com.example.projetkotlin.Domain.UseCase.CreateUserUseCase
import com.example.projetkotlin.Domain.UseCase.GetUserUseCase
import com.example.projetkotlin.Presentation.Register.RegisterViewModel
import com.example.projetkotlin.Presentation.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val presentationModule = module {
    factory { MainViewModel(get(), get()) }
    factory { ElephantViewModel() }
    factory { RegisterViewModel(get(), get()) }

}

val DomainModule= module{
    factory { CreateUserUseCase(get()) }
    factory { GetUserUseCase(get()) }

}

val DataModule= module{
    single { UserRepository(get()) }
    single {createDataBase(androidContext()) }
}

fun createDataBase(context : Context): DatabaseDao{
    val appDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-name"
    ).build()
    return appDatabase.DatabaseDao()
}
