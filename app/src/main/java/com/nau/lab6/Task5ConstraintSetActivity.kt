package com.nau.lab6

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.Barrier
import androidx.constraintlayout.widget.Group

/**
 * Task 5: Demonstrates advanced ConstraintSet features:
 * - Chains (horizontal and vertical)
 * - Barriers (dynamic positioning based on multiple elements)
 * - Groups (show/hide multiple views together)
 * - Circle constraints (positioning views in a circle)
 */
class Task5ConstraintSetActivity : AppCompatActivity() {
    private lateinit var constraintLayout: ConstraintLayout
    private var isChainCreated = false
    private var isBarrierCreated = false
    private var isCircleCreated = false
    private var isGroupVisible = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task5_constraintset)
        
        constraintLayout = findViewById(R.id.constraintLayout)
        
        setupButtonListeners()
    }

    private fun setupButtonListeners() {
        findViewById<Button>(R.id.createChainButton).setOnClickListener {
            if (!isChainCreated) {
                createChain()
                isChainCreated = true
                (it as Button).text = "Chain Created ✓"
                Toast.makeText(this, "Horizontal chain created", Toast.LENGTH_SHORT).show()
            } else {
                removeChain()
                isChainCreated = false
                (it as Button).text = "Create Chain"
                Toast.makeText(this, "Chain removed", Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<Button>(R.id.createBarrierButton).setOnClickListener {
            if (!isBarrierCreated) {
                createBarrier()
                isBarrierCreated = true
                (it as Button).text = "Barrier Created ✓"
                Toast.makeText(this, "Barrier created", Toast.LENGTH_SHORT).show()
            } else {
                removeBarrier()
                isBarrierCreated = false
                (it as Button).text = "Create Barrier"
                Toast.makeText(this, "Barrier removed", Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<Button>(R.id.createCircleButton).setOnClickListener {
            if (!isCircleCreated) {
                createCircleConstraints()
                isCircleCreated = true
                (it as Button).text = "Circle Created ✓"
                Toast.makeText(this, "Circle constraints applied", Toast.LENGTH_SHORT).show()
            } else {
                removeCircleConstraints()
                isCircleCreated = false
                (it as Button).text = "Circle Constraint"
                Toast.makeText(this, "Circle constraints removed", Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<Button>(R.id.createGroupButton).setOnClickListener {
            toggleGroup()
            (it as Button).text = if (isGroupVisible) "Group Hidden" else "Show Group"
        }
    }

    private fun createChain() {
        val constraintSet = ConstraintSet()
        constraintSet.clone(constraintLayout)
        
        // Create horizontal chain with three elements
        constraintSet.createHorizontalChain(
            ConstraintSet.PARENT_ID,
            ConstraintSet.LEFT,
            ConstraintSet.PARENT_ID,
            ConstraintSet.RIGHT,
            intArrayOf(R.id.chainElement1, R.id.chainElement2, R.id.chainElement3),
            null,
            ConstraintSet.CHAIN_SPREAD
        )
        
        constraintSet.applyTo(constraintLayout)
    }

    private fun removeChain() {
        val constraintSet = ConstraintSet()
        constraintSet.clone(constraintLayout)
        
        // Reset positions
        constraintSet.connect(R.id.chainElement1, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
        constraintSet.connect(R.id.chainElement2, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
        constraintSet.connect(R.id.chainElement3, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
        
        constraintSet.applyTo(constraintLayout)
    }

    private fun createBarrier() {
        // Create barrier programmatically
        val barrier = Barrier(this).apply {
            id = View.generateViewId()
            type = Barrier.END
            referencedIds = intArrayOf(R.id.barrierElement1, R.id.barrierElement2)
        }
        
        constraintLayout.addView(barrier)
        
        val constraintSet = ConstraintSet()
        constraintSet.clone(constraintLayout)
        
        // Position the dependent element after the barrier
        constraintSet.connect(
            R.id.barrierDependent,
            ConstraintSet.START,
            barrier.id,
            ConstraintSet.END,
            16
        )
        
        constraintSet.applyTo(constraintLayout)
        
        // Store barrier id for later removal
        constraintLayout.setTag(R.id.barrierDependent, barrier.id)
    }

    private fun removeBarrier() {
        val barrierId = constraintLayout.getTag(R.id.barrierDependent) as? Int
        if (barrierId != null) {
            val barrier = constraintLayout.findViewById<View>(barrierId)
            constraintLayout.removeView(barrier)
            
            val constraintSet = ConstraintSet()
            constraintSet.clone(constraintLayout)
            constraintSet.connect(
                R.id.barrierDependent,
                ConstraintSet.START,
                ConstraintSet.PARENT_ID,
                ConstraintSet.START
            )
            constraintSet.applyTo(constraintLayout)
        }
    }

    private fun createCircleConstraints() {
        val constraintSet = ConstraintSet()
        constraintSet.clone(constraintLayout)
        
        val radius = 150 // pixels
        val angles = listOf(0f, 90f, 180f, 270f)
        val elementIds = listOf(
            R.id.circleElement1,
            R.id.circleElement2,
            R.id.circleElement3,
            R.id.circleElement4
        )
        
        // Position each element in a circle around the center
        elementIds.forEachIndexed { index, elementId ->
            constraintSet.constrainCircle(
                elementId,
                R.id.circleCenter,
                radius,
                angles[index]
            )
        }
        
        constraintSet.applyTo(constraintLayout)
    }

    private fun removeCircleConstraints() {
        val constraintSet = ConstraintSet()
        constraintSet.clone(constraintLayout)
        
        val elementIds = listOf(
            R.id.circleElement1,
            R.id.circleElement2,
            R.id.circleElement3,
            R.id.circleElement4
        )
        
        // Reset to original position (top-start of center)
        elementIds.forEach { elementId ->
            constraintSet.clear(elementId, ConstraintSet.START)
            constraintSet.clear(elementId, ConstraintSet.TOP)
            constraintSet.clear(elementId, ConstraintSet.END)
            constraintSet.clear(elementId, ConstraintSet.BOTTOM)
            
            constraintSet.connect(elementId, ConstraintSet.TOP, R.id.circleCenter, ConstraintSet.TOP)
            constraintSet.connect(elementId, ConstraintSet.START, R.id.circleCenter, ConstraintSet.START)
        }
        
        constraintSet.applyTo(constraintLayout)
    }

    private fun toggleGroup() {
        // Create group programmatically if it doesn't exist
        var group = constraintLayout.findViewWithTag<Group>("dynamicGroup")
        
        if (group == null) {
            group = Group(this).apply {
                id = View.generateViewId()
                tag = "dynamicGroup"
                referencedIds = intArrayOf(R.id.groupElement1, R.id.groupElement2)
            }
            constraintLayout.addView(group)
        }
        
        isGroupVisible = !isGroupVisible
        group.visibility = if (isGroupVisible) View.VISIBLE else View.GONE
        
        Toast.makeText(
            this,
            if (isGroupVisible) "Group shown" else "Group hidden",
            Toast.LENGTH_SHORT
        ).show()
    }
}
