package com.example.loremgenerator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputBinding
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.databinding.DataBindingUtil
import com.example.loremgenerator.R
import com.example.loremgenerator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myData: = MyData{"Crated by me"}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(R.layout.activity_main)
        val spinnerCheck = findViewById<Spinner>(R.id.spinner)
        binding.myData = myData

        val ipsumList = getResources().getStringArray(R.array.dropList)
        binding.creatorButton.setOnClickListener {
            pickCreatorName(it)
        }
        binding.creatorText.setOnClickListener {
            changeCreatorName(it)
        }

        if(spinnerCheck != null){
            val arrayAdapter = ArrayAdapter(this, android.r.layout.simple_spinner_item,ipsumList)
            binding.spinner.adapter = arrayAdapter

            binding.spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    if (position == 0){
                        binding.loremText.text = getString(R.string.lorem_text1)
                    }

                    if (position == 1){
                        binding.loremText.text = getString(R.string.lorem_text2)
                    }

                    if (position == 2){
                        binding.loremText.text = getString(R.string.lorem_text3)
                    }

                    if (position == 3){
                        binding.loremText.text = getString(R.string.lorem_text4)
                    }

                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }
            }
        }

    private fun pickCreatorName(view: View){
        binding.apply {
            myData?.creator = creatorFill.text.toString()
            invalidateAll()
            creatorFill.visibility = View.GONE
            creatorButton.visibility = View.GONE
            creatorText.visibility = View.GONE
        }
    }

        //hide keyboard
        val inm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inm.hideSoftInputFromWindow(view.windowToken, 0)
    }
    private fun changeCreatorName(view: View){
        binding.apply {
            creatorText.visibility = View.GONE
            creatorFill.visibility = View.GONE
            creatorButton.visibility = View.GONE
            creatorFill.requestFocus()
        }

        val inm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inm.showSoftInput(binding.creatorFill, 0)
    }
}