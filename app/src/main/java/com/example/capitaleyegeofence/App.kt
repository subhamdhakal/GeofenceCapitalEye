package com.example.capitaleyegeofence

import android.app.Application
import com.facebook.stetho.Stetho

class App:Application(){
    private lateinit var repository: ReminderRepository
    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
        repository = ReminderRepository(this)

    }
    fun getRepository()=repository

}