package com.example.starwars.activity

import android.app.Application
import com.example.starwars.retrofit.AdapterRest

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AdapterRest.init()
    }
}