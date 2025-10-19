package com.nau.lab6

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * Task 4: Demonstrates ConstraintLayout positioning and constraints
 * Shows various ways to position elements using constraints:
 * - Parent constraints
 * - Element-to-element constraints
 * - Guidelines
 * - Centering
 */
class Task4ConstraintLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task4_constraintlayout)
        
        // Set up click listeners for all buttons
        val buttonIds = listOf(
            R.id.topLeftButton,
            R.id.topRightButton,
            R.id.aboveCenterButton,
            R.id.belowCenterButton,
            R.id.footerButton1,
            R.id.footerButton2,
            R.id.guidelineButton
        )
        
        buttonIds.forEach { buttonId ->
            findViewById<Button>(buttonId).setOnClickListener { view ->
                val button = view as Button
                Toast.makeText(this, "${button.text} clicked", Toast.LENGTH_SHORT).show()
            }
        }
        
        // Show comparison info
        Toast.makeText(
            this,
            "ConstraintLayout: Flatter hierarchy than RelativeLayout, better performance",
            Toast.LENGTH_LONG
        ).show()
    }
}
