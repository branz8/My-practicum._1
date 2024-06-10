package com.example.mypracticumexam

import android.os.Bundle
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class DetailedViewActivity : AppCompatActivity() {
    private val daysOfWeek = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    private val temperatures = arrayOf(
        Pair(25, 12),
        Pair(29, 15),
        Pair(18, 10),
        Pair(20, 14),
        Pair(22, 16),
        Pair(19, 11),
        Pair(23, 12)
    )
    private val weatherConditions = arrayOf(
        "Sunny", "Cloudy", "Raining", "Sunny", "Cloudy", "Raining", "Sunny"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)  // Enable back button

        val listView: ListView = findViewById(R.id.listView)
        val weatherDetails = Array(temperatures.size) { i ->
            "${daysOfWeek[i]}: Min ${temperatures[i].second}°C, Max ${temperatures[i].first}°C - ${weatherConditions[i]}"
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, weatherDetails)
        listView.adapter = adapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()  // Close the activity and return to the previous one
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
