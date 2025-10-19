package com.nau.lab6

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(32, 32, 32, 32)
        }
        
        val tasks = listOf(
            "Task 1: LinearLayout + FrameLayout" to Task1LinearLayoutActivity::class.java,
            "Task 2: RelativeLayout" to Task2RelativeLayoutActivity::class.java,
            "Task 3: Dynamic Manipulation" to Task3DynamicActivity::class.java,
            "Task 4: ConstraintLayout" to Task4ConstraintLayoutActivity::class.java,
            "Task 5: ConstraintSet" to Task5ConstraintSetActivity::class.java
        )
        
        tasks.forEach { (title, activityClass) ->
            Button(this).apply {
                text = title
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    setMargins(0, 0, 0, 16)
                }
                setOnClickListener {
                    startActivity(Intent(this@MainActivity, activityClass))
                }
                layout.addView(this)
            }
        }
        
        setContentView(layout)
    }
}
