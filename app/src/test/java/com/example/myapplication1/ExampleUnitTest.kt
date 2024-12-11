package com.example.myapplication1

import org.junit.Test
import org.junit.Assert.*

class ExampleUnitTest {
    private val exchangeRates = mapOf(
        "USD" to 1.0,
        "EUR" to 0.92,
        "CHF" to 0.91,
        "RUB" to 85.0
    )

    private fun convertCurrency(amount: Double, fromCurrency: String, toCurrency: String): Double {
        val fromRate = exchangeRates[fromCurrency]
        val toRate = exchangeRates[toCurrency]

        if (fromRate == null || toRate == null) {
            return amount
        }

        return (amount / fromRate) * toRate
    }

    @Test
    fun testCurrencyConversion() {
        val amount = 100.0


        val result = convertCurrency(amount, "USD", "EUR")
        assertEquals(92.0, result, 0.01)


        val result2 = convertCurrency(amount, "EUR", "RUB")


        val expectedResult = (amount / 0.92) * 85.0
        assertEquals(expectedResult, result2, 0.01)
    }
}

