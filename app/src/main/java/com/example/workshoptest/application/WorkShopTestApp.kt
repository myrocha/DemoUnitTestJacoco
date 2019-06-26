package com.example.workshoptest.application

import android.app.Application
import com.example.workshoptest.di.*
import org.koin.android.ext.android.startKoin

class WorkShopTestApp : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(networkModule, loginViewModelModule, databaseModule, registerViewModelModule, mainViewModelModule))
    }
}