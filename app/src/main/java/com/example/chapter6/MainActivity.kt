package com.example.chapter6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        contohThreadSatu()
//        contohHandler()
        contohHandlerThread()
//        contohHT()
    }

    fun contohThreadSatu(){
        Thread(Runnable {
            btn_change.setOnClickListener {
                tv_satu.post(Runnable { tv_satu.text = "Hello binar academy" })
            }
            tv_satu.post(Runnable { tv_satu.text = "Hello world" })
            tv_dua.postDelayed(Runnable { tv_dua.text = "Welcome jeje" }, 2000)
        })
    }

    fun contohHandler(){
        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            startActivity(Intent(this,HitungUmur::class.java))
        },3000)

        Handler(Looper.getMainLooper()).post(Runnable {
            tv_dua.setText("Hello")
        })
    }

    fun contohHandlerThread(){
        val handler = object : Handler(Looper.getMainLooper()){
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                val pesan2 = msg.obj as String
                tv_dua.text = pesan2
            }
        }

        Thread(Runnable {
            val a = "Contoh Handler Thread"
            val pesan = Message.obtain()
            pesan.obj = a
            pesan.target = handler
            pesan.sendToTarget()
        })
    }

    fun contohHT(){
        val targetHandler = object : Handler(Looper.getMainLooper()){
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                val a = msg.obj as String
                tv_satu.text = a
            }
        }

        Thread(Runnable {
            val a = Message.obtain()
            a.obj = "qwerty"
            a.target = targetHandler
            a.sendToTarget()
        })
    }
}