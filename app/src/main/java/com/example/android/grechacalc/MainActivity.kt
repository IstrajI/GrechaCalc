package com.example.android.grechacalc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val GRECHA_COST = 10090
    private val GRECHA_WEIGHT = 800
    private val GRECHA_PORTION = 65
    private val GRECHA_PER_DAY_PORTION = 3

    private lateinit var initialCostInputEditText : EditText
    private lateinit var calculateButton : Button
    private lateinit var resultPortionsTextView : TextView
    private lateinit var resultDaysTextView : TextView
    private lateinit var resultCostText : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialCostInputEditText = findViewById(R.id.edit_text_main_init_cost_input)
        calculateButton = findViewById(R.id.button_main_calculate)
        resultPortionsTextView = findViewById(R.id.main_result_portions_text)
        resultDaysTextView = findViewById(R.id.main_result_days_text)
        resultCostText = findViewById(R.id.main_result_cost_text)

        calculateButton.setOnClickListener({
            val initialCost = initialCostInputEditText.text.toString().toInt()
            val amountOfGrecha = initialCost / GRECHA_COST
            val numberOfPortions = amountOfGrecha * GRECHA_WEIGHT.toFloat() / GRECHA_PORTION
            val numberOfDays = numberOfPortions / GRECHA_PER_DAY_PORTION

            resultCostText.text = amountOfGrecha.toString()
            resultPortionsTextView.text = numberOfPortions.toString()
            resultDaysTextView.text = numberOfDays.toString()
        })
    }
}
