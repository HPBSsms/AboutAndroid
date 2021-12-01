package com.view.myapplication.kotlin

import android.app.Application
import android.content.Context

class MyApp : Application() {
    companion object {
        var mAppContext: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        mAppContext = applicationContext
    }
}