package com.nau.lab6

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * Task 2: Demonstrates RelativeLayout with elements positioned 
 * relative to parent and relative to each other
 */
class Task2RelativeLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task2_relativelayout)
        
        // Set up click listeners for all buttons
        val buttonIds = listOf(
            R.id.topLeftButton,
            R.id.topRightButton,
            R.id.aboveCenterButton,
            R.id.belowCenterButton,
            R.id.bottomLeftButton,
            R.id.bottomRightButton,
            R.id.toRightOfLeftButton,
            R.id.toLeftOfRightButton
        )
        
        buttonIds.forEach { buttonId ->
            findViewById<Button>(buttonId).setOnClickListener { view ->
                val button = view as Button
                Toast.makeText(this, "${button.text} clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
