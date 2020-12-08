package com.example.projetkotlin.injection

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

open class NewApplication : Application(){
    override fun onCreate(){
        super.onCreate()
        // start Koin!
        startKoin {
            // Android context
            androidContext(this@NewApplication)
            // modules
            modules(presentationModule, DataModule, DomainModule)
        }
    }

}