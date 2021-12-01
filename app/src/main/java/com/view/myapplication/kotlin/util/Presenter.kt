package com.view.myapplication.kotlin.util

import android.widget.Toast
import com.view.myapplication.kotlin.MyApp

class Presenter {
    fun onSaveClick(task : Task?) {
        Toast.makeText(MyApp.mAppContext, "presenter.onSaveClick(task)", Toast.LENGTH_SHORT).show()
    }
}