package com.view.myapplication.kotlin.util

import android.view.View
import android.widget.Toast

class MyHandlers {
    fun onclickFriend(view: View) {
        Toast.makeText(view.context, "onclickFriend", Toast.LENGTH_SHORT).show()
    }
}