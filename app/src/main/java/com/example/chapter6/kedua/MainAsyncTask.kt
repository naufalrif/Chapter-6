package com.example.chapter6.kedua

import android.app.ProgressDialog
import android.content.Context
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chapter6.R
import kotlinx.android.synthetic.main.activity_main_async_task.*

@Suppress("DEPRECATION")
class MainAsyncTask : AppCompatActivity() {
    lateinit var cont : Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_async_task)
        cont = this

        contohAsyncTask().execute()

//        val a = 7+8

    }

    inner class contohAsyncTask : AsyncTask<Int,Void,String>(){

        lateinit var pdialog : ProgressDialog

        override fun onPreExecute() {
            super.onPreExecute()
            pdialog = ProgressDialog(cont)
            pdialog.show()
        }

        override fun doInBackground(vararg p0: Int?): String {
            val berat = et_berat.text.toString().toDouble()
            val tinggi = et_tinggibadan.text.toString().toDouble()
            val bmi = berat/(tinggi*tinggi)
            var output = " "
            if (bmi < 18.5){
                output = "Kurus"
            }else if (bmi >= 18.5 && bmi <= 24.9){
                output = "Normal"
            }else if (bmi >= 25 && bmi <= 29.9){
                output = "Over"
            }else{
                output = "Obes"
            }
            return output
        }

        override fun onProgressUpdate(vararg values: Void?) {
            super.onProgressUpdate(*values)
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
        }

    }
}