package com.example.myapplication1

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var amountEditText: EditText
    private lateinit var fromCurrencySpinner: Spinner
    private lateinit var toCurrencySpinner: Spinner
    private lateinit var resultTextView: TextView
    private lateinit var convertButton: Button

    private val currencies = listOf("USD", "EUR", "CHF","RUB")

    private val exchangeRates = mapOf(
        "USD" to 1.0,
        "EUR" to 0.92,
        "CHF" to 0.91,
        "RUB" to 85.0
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        amountEditText = findViewById<EditText>(R.id.amountEditText)
        fromCurrencySpinner = findViewById<Spinner>(R.id.fromCurrencySpinner)
        toCurrencySpinner = findViewById<Spinner>(R.id.toCurrencySpinner)
        resultTextView = findViewById<TextView>(R.id.resultTextView)
        convertButton = findViewById<Button>(R.id.convertButton)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, currencies)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        fromCurrencySpinner.adapter = adapter
        toCurrencySpinner.adapter = adapter

        convertButton.setOnClickListener {
            val amount = amountEditText.text.toString().toDoubleOrNull()
            val fromCurrency = fromCurrencySpinner.selectedItem.toString()
            val toCurrency = toCurrencySpinner.selectedItem.toString()

            if (amount != null) {
                convertCurrency(amount, fromCurrency, toCurrency)
            }
        }

    }
    private fun convertCurrency(amount: Double, fromCurrency: String, toCurrency: String) {
        val fromRate = exchangeRates[fromCurrency] ?: 1.0
        val toRate = exchangeRates[toCurrency] ?: 1.0

        // Конвертируем валюту
        val result = (amount / fromRate) * toRate

        val roundedResult = String.format("%.2f", result)

        resultTextView.text = "Ответ: $roundedResult $toCurrency"
    }
}
