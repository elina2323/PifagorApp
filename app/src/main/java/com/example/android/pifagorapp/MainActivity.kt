package com.example.android.pifagorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.android.pifagorapp.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onClickResult(view: View){
        if (!isFieldEmpty()){
            val result = getString(R.string.result_info) + getResult()
            binding.textViewResult.text = result}

    }

    private fun isFieldEmpty():Boolean{
        binding.apply {
            if(editA.text.isNullOrEmpty())editA.error = getString(R.string.error_a)
            if(editB.text.isNullOrEmpty())editB.error = getString(R.string.error_b)
            return editA.text.isNullOrEmpty() || editB.text.isNullOrEmpty()
        }
    }

    private fun getResult(): String{
        val a:Double
        val b:Double
        binding.apply {
            a = editA.text.toString().toDouble()
            b = editB.text.toString().toDouble()
        }
        return sqrt((a.pow(2) + (b.pow(2)))).toString()
    }
}