package com.example.chapter6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_hitung_umur.*

class HitungUmur : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hitung_umur)
        hitungUmur()
    }

    fun hitungUmur(){
        Thread(Runnable {


            btn_input.setOnClickListener {
                val umur = et_umur.text.toString()
                val nama = et_nama.text.toString()
                val umurNow = 2022 - umur.toInt()
                tv_out_name.post(Runnable { tv_out_name.text = nama })
                tv_out_umur.post(Runnable { tv_out_umur.text = umurNow.toString() })
            }
        }).start()
    }
}