package com.random.headsortails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var resultText: TextView
    lateinit var rollButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultText=findViewById(R.id.resultText) as TextView
        rollButton=findViewById(R.id.rollButton) as Button
        rollButton.setOnClickListener {
            rollDice()
            Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun rollDice() {
        val randomInt=Random().nextInt(2)+0  
		
        if (randomInt == 0){
            resultText.text="HEAD"
        }
        else{
            resultText.text="TAIL"
        }


    }
}
