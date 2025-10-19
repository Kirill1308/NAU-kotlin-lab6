package com.nau.lab6

import android.os.Bundle
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * Task 3: Demonstrates dynamic manipulation of UI components using Kotlin code
 * Removes a component from its current position and inserts it in a new location
 */
class Task3DynamicActivity : AppCompatActivity() {
    private var moveState = 0
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task3_dynamic)
        
        val rootLayout = findViewById<RelativeLayout>(R.id.rootLayout)
        val moveButton = findViewById<Button>(R.id.moveButton)
        val movableTextView = findViewById<TextView>(R.id.movableTextView)
        
        moveButton.setOnClickListener {
            // Remove the view from its current position
            rootLayout.removeView(movableTextView)
            
            // Create new layout parameters based on current state
            val params = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
            )
            
            when (moveState) {
                0 -> {
                    // Move to top left (below moveButton)
                    params.addRule(RelativeLayout.BELOW, R.id.moveButton)
                    params.addRule(RelativeLayout.ALIGN_PARENT_START)
                    params.setMargins(16, 16, 0, 0)
                    movableTextView.text = "Top Left Position"
                    Toast.makeText(this, "Moved to Top Left", Toast.LENGTH_SHORT).show()
                }
                1 -> {
                    // Move to bottom right
                    params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
                    params.addRule(RelativeLayout.ALIGN_PARENT_END)
                    params.setMargins(0, 0, 16, 16)
                    movableTextView.text = "Bottom Right Position"
                    Toast.makeText(this, "Moved to Bottom Right", Toast.LENGTH_SHORT).show()
                }
                2 -> {
                    // Move to align with top left reference button
                    params.addRule(RelativeLayout.ALIGN_TOP, R.id.topLeftRef)
                    params.addRule(RelativeLayout.END_OF, R.id.topLeftRef)
                    params.setMargins(16, 0, 0, 0)
                    movableTextView.text = "Next to Top Left Ref"
                    Toast.makeText(this, "Moved next to reference button", Toast.LENGTH_SHORT).show()
                }
                3 -> {
                    // Move to align with bottom right reference button
                    params.addRule(RelativeLayout.ALIGN_BOTTOM, R.id.bottomRightRef)
                    params.addRule(RelativeLayout.START_OF, R.id.bottomRightRef)
                    params.setMargins(0, 0, 16, 0)
                    movableTextView.text = "Next to Bottom Right Ref"
                    Toast.makeText(this, "Moved next to bottom reference", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    // Return to center
                    params.addRule(RelativeLayout.CENTER_IN_PARENT)
                    movableTextView.text = "Center Position (Initial)"
                    Toast.makeText(this, "Returned to center", Toast.LENGTH_SHORT).show()
                }
            }
            
            // Add the view back with new parameters
            movableTextView.layoutParams = params
            rootLayout.addView(movableTextView)
            
            // Cycle through states
            moveState = (moveState + 1) % 5
        }
    }
}
