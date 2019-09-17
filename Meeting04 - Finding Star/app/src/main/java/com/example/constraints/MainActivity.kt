package com.example.constraints

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.*
import androidx.databinding.DataBindingUtil
import com.example.constraints.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var selectedView: View
    private val bigStarOnResId = 17301516
    private val bigStarOffId = 17301515
    private var selectedId = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val boxesId: List<Int> = listOf(
            binding.boxOneText.id,
            binding.boxTwoText.id,
            binding.boxThreeText.id,
            binding.boxFourText.id,
            binding.boxFiveText.id
        )
        selectedId = boxesId[Random.nextInt(0, 5)]
        Log.d("ActivityMain :: ", "SelectedID: ${selectedId}; From: ${boxesId}")
        setListeners()
    }

    private fun setBehavior(view: View) {
        if(View.id == selectedId) {
            setButtonBackground(view, bigStarOnResId)
            selectedView = view
            winHandler()
        }
        else setButtonBackground(view, bigStarOffId)
    }

    private fun setButtonBackground(view: View, buttonIcon: Int){
        view.setBackgroundResource(buttonIcon)
    }

    private fun winHandler() {
        Toast.makeText(this, "You Win! Tap the shining star to play again.", Toast.LENGTH_LONG).show()
        selectedView.setOnClickListener {
            reset()
        }
    }

    private fun reset() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val boxesId: List<Int> = listOf(
            binding.boxOneText.id,
            binding.boxTwoText.id,
            binding.boxThreeText.id,
            binding.boxFourText.id,
            binding.boxFiveText.id
        )

        selectedId = boxesId[Random.nextInt(0,5)]
        Log.d("ActivityMain :: ", "SelectedID: ${selectedId}; From: ${boxesId}")

        val boxOneText = findViewById<TextView>(R.id.box_one_text)
        val boxTwoText = findViewById<TextView>(R.id.box_two_text)
        val boxThreeText = findViewById<TextView>(R.id.box_three_text)
        val boxFourText = findViewById<TextView>(R.id.box_four_text)
        val boxFiveText = findViewById<TextView>(R.id.box_five_text)

        val clickableViews: List<View> =
            listOf(boxOneText, boxTwoText, boxThreeText, boxFourText, boxFiveText)

        for (item in clickableViews) {
            item.setOnClickListener(
                setBehavior(it)
            )
            item.setBackgroundColor(Color.WHITE)
        }
    }

    private fun setListeners() {
        val boxOneText = findViewById<TextView>(R.id.box_one_text)
        val boxTwoText = findViewById<TextView>(R.id.box_two_text)
        val boxThreeText = findViewById<TextView>(R.id.box_three_text)
        val boxFourText = findViewById<TextView>(R.id.box_four_text)
        val boxFiveText = findViewById<TextView>(R.id.box_five_text)

        val clickableViews: List<View> =
            listOf(boxOneText, boxTwoText, boxThreeText, boxFourText, boxFiveText)

        for (item in clickableViews) {
            item.setOnClickListener(
                setBehavior(it)
            )
        }
    }
}