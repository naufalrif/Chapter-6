package com.example.chapter6.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chapter6.R
import kotlinx.android.synthetic.main.activity_main_async_task.*
import kotlinx.android.synthetic.main.activity_main_coroutines.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainCoroutines : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_coroutines)
        coroutinesDua()
    }

    fun coroutinesDua(){
        GlobalScope.launch {
            CoroutineScope(Dispatchers.Main).launch {
                btn_input_berat_coro.setOnClickListener {
                    val beratCor = et_berat_coro.text.toString().toDouble()
                    val tinggiCor = et_tinggibadan_coro.text.toString().toDouble()
                    val bmi = beratCor/(tinggiCor*tinggiCor)
                    var output = " "
                    if (bmi < 18.5){
                        tv_out_bmi_coro.text = "Kurus"
                    }else if (bmi in 18.5..24.9){
                        tv_out_bmi_coro.text = "Normal"
                    }else if (bmi in 25.0..29.9){
                        tv_out_bmi_coro.text = "Over"
                    }else{
                        tv_out_bmi_coro.text = "Obes"
                    }
                }
            }
        }
    }
}