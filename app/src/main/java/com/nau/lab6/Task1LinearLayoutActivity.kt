package com.nau.lab6

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * Task 1: Demonstrates nested LinearLayout with FrameLayout
 * Shows how to arrange UI components using nested LinearLayouts and 
 * overlay elements using FrameLayout
 */
class Task1LinearLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task1_linearlayout)
        
        // Set up button click listeners to demonstrate interactivity
        findViewById<Button>(R.id.headerButton).setOnClickListener {
            Toast.makeText(this, "Header Button Clicked", Toast.LENGTH_SHORT).show()
        }
        
        findViewById<Button>(R.id.leftButton1).setOnClickListener {
            Toast.makeText(this, "Left Button 1 Clicked", Toast.LENGTH_SHORT).show()
        }
        
        findViewById<Button>(R.id.leftButton2).setOnClickListener {
            Toast.makeText(this, "Left Button 2 Clicked", Toast.LENGTH_SHORT).show()
        }
        
        findViewById<Button>(R.id.footerButton).setOnClickListener {
            Toast.makeText(this, "Footer Button Clicked", Toast.LENGTH_SHORT).show()
        }
        
        findViewById<TextView>(R.id.frameTextView).setOnClickListener {
            Toast.makeText(this, "FrameLayout Top Layer Clicked", Toast.LENGTH_SHORT).show()
        }
    }
}
