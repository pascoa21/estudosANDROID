package com.example.conversordetemperatura

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton

class MainActivity : AppCompatActivity() {


    lateinit var editText: EditText
    lateinit var celsiusBtn: RadioButton
    lateinit var fahrnheintBtn: RadioButton
    lateinit var converterBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.valor_temp)
        celsiusBtn = findViewById(R.id.celsius)
        fahrnheintBtn = findViewById(R.id.fahrenheit)
        converterBtn = findViewById(R.id.conversion)
        converterBtn.setOnClickListener { converter(it) }

    }
    fun converter(view: View) {
        var temp: Double = editText.text.toString().toDouble()

        if (celsiusBtn.isChecked) {
            temp = (temp - 32) * 5 / 9
        }
        else if (fahrnheintBtn.isChecked){
            temp = (temp * 9/5)+32
        }
       editText.setText(temp.toString())
    }

}


