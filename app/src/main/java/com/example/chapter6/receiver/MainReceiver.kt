package com.example.chapter6.receiver

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chapter6.R

class MainReceiver : AppCompatActivity() {
    lateinit var penerima : AirplaneModeReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_receiver)
        penerima = AirplaneModeReceiver()
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(penerima,it)
        }
    }
}