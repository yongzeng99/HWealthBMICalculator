package com.example.hwealthbmicalculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var heightInput: EditText
    lateinit var weightInput: EditText
    lateinit var resultImage: ImageView
    lateinit var setTextResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultImage = findViewById(R.id.imageViewProfile)
        heightInput= findViewById(R.id.editTextHeight)
        weightInput = findViewById(R.id.editTextWeight)
        setTextResult = findViewById(R.id.textResult)

        val calculateButton : Button = findViewById(R.id.buttonCalculate)
        val resetButton : Button = findViewById(R.id.buttonReset)

        calculateButton.setOnClickListener{ calculateBMI() }
        resetButton.setOnClickListener { resetBMI() }
    }

    private fun calculateBMI(){
        //convert cm to meters
        val heightDouble: Double = heightInput.text.toString().toDouble() / 100
        val weightDouble: Double = weightInput.text.toString().toDouble()
        val result: Double =  weightDouble / Math.pow(heightDouble, 2.0)



        if (result < 18.5){
            setTextResult.setTextColor(Color.parseColor("#2b4bff"))
            setTextResult.setText("Underweight")
        } else if (result >= 18.5 && result <= 24.9) {
            setTextResult.setTextColor(Color.parseColor("#40ff49"))
            setTextResult.setText("Normal")
        } else if (result >= 25 && result <= 29.9){
            setTextResult.setTextColor(Color.parseColor("#ffa217"))
            setTextResult.setText("Overweight")
        } else if (result >= 30){
            setTextResult.setTextColor(Color.parseColor("#ff2626"))
            setTextResult.setText("Obese")
        }


    }

    private fun resetBMI(){

        setTextResult.setText("")
        setTextResult.setText("")
        heightInput.setText("")
        weightInput.setText("")

    }
}
