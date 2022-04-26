package com.example.chapter6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import kotlinx.android.synthetic.main.activity_hitung_bmi.*

class HitungBMI : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hitung_bmi)
        hitungBMIlagi()
    }

//    fun hitungBMI(){
//
//        Thread(Runnable {
//            btn_input_bb.setOnClickListener {
//                val berat = et_bb.text.toString().toInt()
//                val tinggi = et_tinggi.text.toString().toInt()
//                val bmi = berat / (tinggi*tinggi)
//                if (bmi )
//            }
//        })
//    }

    fun hitungBMIlagi(){
        val handler = object : Handler(Looper.getMainLooper()){
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                val pesanBMI = msg.obj as String
                tv_out_bmi.text = pesanBMI
            }
        }

        Thread(Runnable {
            btn_input_bb.setOnClickListener {
                val berat = et_bb.text.toString().toInt()
                val tinggi = et_tinggi.text.toString().toInt()
                val tinggiKuadrat = tinggi*tinggi
                val bbkurus = "Kurus"
                val bbnormal = "Normal"
                val bbover = "Overweight"
                val bbobes = "Obesitas"
                val pesan = Message.obtain()
                val bmi = berat/tinggiKuadrat
                if (bmi < 18.5){
                    pesan.obj = bbkurus
                    pesan.target = handler
                    pesan.sendToTarget()
                }else if (bmi >= 18.5 && bmi <= 24.9){
                    pesan.obj = bbnormal
                    pesan.target = handler
                    pesan.sendToTarget()
                }else if (bmi >= 25 && bmi <= 29.9){
                    pesan.obj = bbover
                    pesan.target = handler
                    pesan.sendToTarget()
                }else{
                    pesan.obj = bbobes
                    pesan.target = handler
                    pesan.sendToTarget()
                }
            }
        }).start()
    }
}