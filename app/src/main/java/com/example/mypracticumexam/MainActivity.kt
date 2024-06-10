package com.example.mypracticumexam


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val temperatures = arrayOf(
        Pair(25, 12),
        Pair(29, 15),
        Pair(18, 10),
        Pair(20, 14),
        Pair(22, 16),
        Pair(19, 11),
        Pair(23, 12)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val avgTempTextView: TextView = findViewById(R.id.avgTempTextView)
        val viewDetailsButton: Button = findViewById(R.id.viewDetailsButton)
        val clearDataButton: Button = findViewById(R.id.clearDataButton)

        val averageTemperature = calculateAverageTemperature(temperatures)
        avgTempTextView.text = "Average Temperature: $averageTemperature°C"

        viewDetailsButton.setOnClickListener {
            val intent = Intent(this, DetailedViewActivity::class.java)
            startActivity(intent)
        }

        clearDataButton.setOnClickListener {
            // Clear data functionality
        }
    }

    private fun calculateAverageTemperature(temperatures: Array<Pair<Int, Int>>): Double {
        var totalMinTemp = 0
        var totalMaxTemp = 0
        for (temp in temperatures) {
            totalMinTemp += temp.first
            totalMaxTemp += temp.second
        }
        return (totalMinTemp + totalMaxTemp) / (temperatures.size * 2.0)
    }
}
