# Lab 6 - Android Studio Layouts

This project demonstrates various Android layout techniques as part of Laboratory Work 6.

## Project Structure

The project contains 5 main activities, each demonstrating a different layout concept:

### Task 1: LinearLayout with FrameLayout
**Activity:** `Task1LinearLayoutActivity`  
**Layout:** `activity_task1_linearlayout.xml`

Demonstrates:
- Nested LinearLayout configurations (vertical and horizontal)
- Using layout_weight for proportional sizing
- FrameLayout for overlaying multiple elements
- Creating complex UI with nested layouts

### Task 2: RelativeLayout
**Activity:** `Task2RelativeLayoutActivity`  
**Layout:** `activity_task2_relativelayout.xml`

Demonstrates:
- Positioning elements relative to parent container
- Positioning elements relative to each other
- Various alignment rules (alignParentTop, alignParentBottom, centerInParent, etc.)
- Creating flexible layouts without nesting

### Task 3: Dynamic Component Manipulation
**Activity:** `Task3DynamicActivity`  
**Layout:** `activity_task3_dynamic.xml`

Demonstrates:
- Programmatically removing views from layouts
- Dynamically changing layout parameters in Kotlin code
- Repositioning components at runtime
- Responding to user interactions to modify UI

### Task 4: ConstraintLayout
**Activity:** `Task4ConstraintLayoutActivity`  
**Layout:** `activity_task4_constraintlayout.xml`

Demonstrates:
- Modern ConstraintLayout positioning
- Parent constraints and element-to-element constraints
- Using guidelines for alignment
- Creating flat view hierarchies
- Comparison with RelativeLayout approach

### Task 5: ConstraintSet Advanced Features
**Activity:** `Task5ConstraintSetActivity`  
**Layout:** `activity_task5_constraintset.xml`  
**ConstraintSet XML:** `constraint_set_alternative.xml`

Demonstrates:
- Creating and manipulating chains (horizontal/vertical)
- Using barriers for dynamic positioning
- Grouping views for collective visibility control
- Circle constraints (constraintCircle) for radial positioning
- Both programmatic and XML-based ConstraintSet approaches

## Building and Running

This is a standard Android project. To build and run:

1. Open the project in Android Studio
2. Sync Gradle files
3. Run on an emulator or physical device (API 24+)

## Requirements

- Android SDK 24 or higher
- Kotlin 1.9.0
- Android Gradle Plugin 8.1.0
- ConstraintLayout 2.1.4

## Key Learning Outcomes

1. **LinearLayout**: Understanding nested layouts and weight distribution
2. **FrameLayout**: Overlaying views and z-ordering
3. **RelativeLayout**: Relative positioning and layout rules
4. **ConstraintLayout**: Modern, performant layout with flat hierarchies
5. **ConstraintSet**: Advanced constraint manipulation programmatically
6. **Layout Comparison**: Understanding when to use each layout type

## Additional Resources

For detailed task descriptions, see `resources/tz.pdf` (in Ukrainian).
