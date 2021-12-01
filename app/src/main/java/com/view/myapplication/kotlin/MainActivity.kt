package com.view.myapplication.kotlin

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.view.myapplication.R
import com.view.myapplication.databinding.ActivityMainKtBinding
import com.view.myapplication.kotlin.data.User
import com.view.myapplication.kotlin.util.MyHandlers
import com.view.myapplication.kotlin.util.Presenter

class MainActivity : AppCompatActivity() {
    private val activityMainKtBinding: ActivityMainKtBinding
        get() {
            val binding: ActivityMainKtBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_main_kt)
            return binding
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainKtBinding =
            activityMainKtBinding
        binding.user = User(null, "Kuc")
        binding.handler = MyHandlers()
        binding.presenter = Presenter()
    }

    fun bt1(view: View) {
        Toast.makeText(this, "点击按钮", Toast.LENGTH_SHORT).show()
    }
}