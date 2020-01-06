package com.example.hwealthbmicalculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.view.ViewCompat.setRotation
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.example.hwealthbmicalculator.databinding.ActivityMainBinding
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.databinding.DataBindingUtil
import android.R.attr.pivotY
import android.R.attr.pivotX
import android.R.attr.angle
import android.graphics.Matrix
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T




class MainActivity : AppCompatActivity() {

    lateinit var heightInput: EditText
    lateinit var weightInput: EditText
    lateinit var resultImage: ImageView
    lateinit var setTextResult: TextView
    lateinit var setBmiResult: TextView
    var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        resultImage = findViewById(R.id.imageViewProfile)
        heightInput= findViewById(R.id.editTextHeight)
        weightInput = findViewById(R.id.editTextWeight)
        setTextResult = findViewById(R.id.textResult)
        setBmiResult = findViewById(R.id.bmiResult)

        val calculateButton : Button = findViewById(R.id.buttonCalculate)

        calculateButton.setOnClickListener{ calculateBMI() }
    }

    private fun calculateBMI(){
        //convert cm to meters
        val heightDouble: Double = heightInput.text.toString().toDouble() / 100
        val weightDouble: Double = weightInput.text.toString().toDouble()
        val result: Double =  weightDouble / Math.pow(heightDouble, 2.0)


        if (result < 18.5){
            setTextResult.setTextColor(Color.parseColor("#2b4bff"))
            setTextResult.setText("Underweight")
            indicator.animate().rotation(15f).start()
            indicator.pivotX = 150f
        } else if (result >= 18.5 && result <= 24.9) {
            setTextResult.setTextColor(Color.parseColor("#40ff49"))
            setTextResult.setText("Normal")
            indicator.animate().rotation(65f).start()
            indicator.pivotX = 150f
        } else if (result >= 25 && result <= 29.9){
            setTextResult.setTextColor(Color.parseColor("#ffa217"))
            setTextResult.setText("Overweight")
            indicator.animate().rotation(115f).start()
            indicator.pivotX = 150f
        } else if (result >= 30){
            setTextResult.setTextColor(Color.parseColor("#ff2626"))
            setTextResult.setText("Obese")
            indicator.animate().rotation(165f).start()
            indicator.pivotX = 150f
        }
        setBmiResult.setText(String.format("%.2f", result))

    }
}
