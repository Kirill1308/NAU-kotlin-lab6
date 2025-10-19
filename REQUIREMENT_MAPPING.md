# Requirement Mapping - Lab 6

This document maps the original requirements from `resources/tz.pdf` to the implementation.

## Original Requirements (from tz.pdf)

### Завдання (Tasks)

#### 1. Розташувати компоненти графічного інтерфейсу, застосовуючи вкладення розміток LinearLayout. Доповнити попереднє розташування додатковими компонентами з використанням розмітки FrameLayout.

**Translation:** Arrange UI components using nested LinearLayout. Supplement the previous arrangement with additional components using FrameLayout layout.

**Implementation:**
- ✅ **File:** `app/src/main/res/layout/activity_task1_linearlayout.xml`
- ✅ **Activity:** `Task1LinearLayoutActivity.kt`
- ✅ **Features:**
  - Nested LinearLayouts (vertical root → horizontal header/footer, vertical left column)
  - FrameLayout demonstrating layer stacking with 3 overlapping elements
  - Header with horizontal LinearLayout containing TextView and Button
  - Body split into two columns: left (LinearLayout) and right (FrameLayout)
  - Footer with vertical LinearLayout
  - Proper use of layout_weight for proportional sizing

#### 2. Використовуючи розмітку RelativeLayout в XML-форматі, розташувати компоненти графічного інтерфейсу з вирівнюванням відносно батьківського елементу та інших елементів графічного інтерфейсу.

**Translation:** Using RelativeLayout in XML format, arrange UI components with alignment relative to parent element and other UI elements.

**Implementation:**
- ✅ **File:** `app/src/main/res/layout/activity_task2_relativelayout.xml`
- ✅ **Activity:** `Task2RelativeLayoutActivity.kt`
- ✅ **Features:**
  - Elements aligned relative to parent:
    - `alignParentTop`, `alignParentBottom`, `alignParentStart`, `alignParentEnd`
    - `centerInParent`, `centerVertical`, `centerHorizontal`
  - Elements aligned relative to other elements:
    - `layout_below`, `layout_above`
    - `layout_toStartOf`, `layout_toEndOf`
    - `alignTop`, `alignBottom`
  - Demonstrates complex positioning without nested layouts
  - 10+ elements positioned using various RelativeLayout rules

#### 3. Використовуючи розмітку попереднього завдання за допомогою Java-коду видалити один з компонентів і вставити його в іншому місці екрану.

**Translation:** Using the layout from the previous task, use Java code (Kotlin in our case) to remove one of the components and insert it in another place on the screen.

**Implementation:**
- ✅ **File:** `app/src/main/java/com/nau/lab6/Task3DynamicActivity.kt`
- ✅ **Layout:** `app/src/main/res/layout/activity_task3_dynamic.xml`
- ✅ **Features:**
  - Uses RelativeLayout as base (similar to Task 2)
  - Kotlin code (equivalent to Java):
    ```kotlin
    rootLayout.removeView(movableTextView)  // Remove component
    val params = RelativeLayout.LayoutParams(...)  // Create new params
    params.addRule(...)  // Add positioning rules
    movableTextView.layoutParams = params  // Update params
    rootLayout.addView(movableTextView)  // Re-add component
    ```
  - Button triggers dynamic repositioning
  - Cycles through 5 different positions
  - Demonstrates programmatic layout manipulation

#### 4. Використовуючи розмітку ConstraintLayout в режимі Design та XML-форматі, виконати завдання 1. Порівняти можливості RelativeLayout та ConstraintLayout.

**Translation:** Using ConstraintLayout in Design mode and XML format, complete task 1. Compare the capabilities of RelativeLayout and ConstraintLayout.

**Implementation:**
- ✅ **File:** `app/src/main/res/layout/activity_task4_constraintlayout.xml`
- ✅ **Activity:** `Task4ConstraintLayoutActivity.kt`
- ✅ **Features:**
  - Similar UI to Task 1 and Task 2, but using ConstraintLayout
  - Demonstrates ConstraintLayout features:
    - Parent constraints (`constraintTop_toTopOf`, `constraintStart_toStartOf`, etc.)
    - Element-to-element constraints
    - Guidelines (vertical guideline at 30%)
    - Centering with opposing constraints
    - Nested LinearLayout within ConstraintLayout
  - **Comparison (shown in Toast message and docs):**
    - ConstraintLayout: Flatter hierarchy, better performance, more flexible
    - RelativeLayout: Simpler for basic positioning, less flexible
    - ConstraintLayout is the modern Android standard

#### 5. За допомогою ConstraintSet створити прив'язки, ланцюжки, бар'єри, групи та використати constraintCircle. Використати ConstraintSet в коді або в xml-файлі.

**Translation:** Using ConstraintSet, create constraints, chains, barriers, groups, and use constraintCircle. Use ConstraintSet in code or in an XML file.

**Implementation:**
- ✅ **File:** `app/src/main/java/com/nau/lab6/Task5ConstraintSetActivity.kt`
- ✅ **Layout:** `app/src/main/res/layout/activity_task5_constraintset.xml`
- ✅ **XML ConstraintSet:** `app/src/main/res/xml/constraint_set_alternative.xml`
- ✅ **Features:**

  **A. Прив'язки (Constraints):**
  - Created programmatically using ConstraintSet
  - Used in all features below

  **B. Ланцюжки (Chains):**
  ```kotlin
  constraintSet.createHorizontalChain(
      ConstraintSet.PARENT_ID, ConstraintSet.LEFT,
      ConstraintSet.PARENT_ID, ConstraintSet.RIGHT,
      intArrayOf(R.id.chainElement1, R.id.chainElement2, R.id.chainElement3),
      null, ConstraintSet.CHAIN_SPREAD
  )
  ```
  - Horizontal chain with 3 elements
  - CHAIN_SPREAD style (evenly distributed)
  - Toggle button to create/remove

  **C. Бар'єри (Barriers):**
  ```kotlin
  val barrier = Barrier(this).apply {
      type = Barrier.END
      referencedIds = intArrayOf(R.id.barrierElement1, R.id.barrierElement2)
  }
  constraintLayout.addView(barrier)
  ```
  - Barrier positioned at END of referenced elements
  - Dependent element constrained to barrier
  - Adapts to longest element dynamically

  **D. Групи (Groups):**
  ```kotlin
  val group = Group(this).apply {
      referencedIds = intArrayOf(R.id.groupElement1, R.id.groupElement2)
  }
  group.visibility = View.VISIBLE // or View.GONE
  ```
  - Controls visibility of multiple views together
  - Toggle button to show/hide group

  **E. constraintCircle:**
  ```kotlin
  constraintSet.constrainCircle(
      elementId,      // View to position
      R.id.circleCenter,  // Center anchor
      150,            // Radius in pixels
      angle           // Angle in degrees (0°, 90°, 180°, 270°)
  )
  ```
  - 4 buttons positioned in a circle
  - Radial positioning around center point
  - Perfect 90° spacing

  **F. ConstraintSet в XML:**
  - Alternative approach shown in `constraint_set_alternative.xml`
  - Demonstrates how to define constraints in XML
  - Can be loaded programmatically with:
    ```kotlin
    constraintSet.load(context, R.xml.constraint_set_alternative)
    constraintSet.applyTo(constraintLayout)
    ```

## Summary of Requirements Coverage

| Requirement | Status | Implementation |
|------------|--------|----------------|
| 1. LinearLayout + FrameLayout | ✅ Complete | Task1LinearLayoutActivity |
| 2. RelativeLayout (XML) | ✅ Complete | Task2RelativeLayoutActivity |
| 3. Dynamic manipulation (code) | ✅ Complete | Task3DynamicActivity |
| 4. ConstraintLayout + comparison | ✅ Complete | Task4ConstraintLayoutActivity |
| 5a. Constraints (прив'язки) | ✅ Complete | Task5ConstraintSetActivity |
| 5b. Chains (ланцюжки) | ✅ Complete | Task5ConstraintSetActivity |
| 5c. Barriers (бар'єри) | ✅ Complete | Task5ConstraintSetActivity |
| 5d. Groups (групи) | ✅ Complete | Task5ConstraintSetActivity |
| 5e. constraintCircle | ✅ Complete | Task5ConstraintSetActivity |
| 5f. ConstraintSet in XML | ✅ Complete | constraint_set_alternative.xml |

## Additional Implementation Details

### Project Structure
- ✅ Proper Android project structure
- ✅ Gradle build configuration
- ✅ AndroidManifest with all activities
- ✅ Resource files (strings, colors)
- ✅ Proper package structure

### Code Quality
- ✅ Well-commented code
- ✅ Proper Kotlin syntax
- ✅ Following Android best practices
- ✅ Interactive elements with user feedback (Toasts)

### Documentation
- ✅ README.md - Project overview
- ✅ IMPLEMENTATION_SUMMARY.md - Detailed implementation guide
- ✅ TASKS_OVERVIEW.md - Visual diagrams of each task
- ✅ REQUIREMENT_MAPPING.md - This file

### Educational Value
- ✅ Progressive difficulty (Task 1 → Task 5)
- ✅ Clear examples of each layout type
- ✅ Practical demonstrations of concepts
- ✅ Comparison between approaches
- ✅ Both declarative (XML) and programmatic (Kotlin) approaches shown

## Testing Checklist

Each task has been implemented with interactive elements that can be tested:

- [ ] Task 1: Open activity, verify nested layouts, click buttons
- [ ] Task 2: Open activity, verify relative positioning, click all buttons
- [ ] Task 3: Open activity, click "Move Component" button multiple times
- [ ] Task 4: Open activity, compare with Task 2, verify constraints
- [ ] Task 5: Open activity, test all 4 features (chains, barriers, circles, groups)

## Theoretical Background (from tz.pdf)

The implementation follows all theoretical guidelines from the PDF:

1. ✅ LinearLayout with orientation, weight, and nesting
2. ✅ FrameLayout for overlaying views
3. ✅ RelativeLayout with parent and sibling positioning
4. ✅ ConstraintLayout as modern standard with advantages:
   - Flatter hierarchy
   - Better performance in most cases
   - Rich visual editor support
   - Advanced features (chains, barriers, groups)
5. ✅ Both advantages and disadvantages discussed in documentation

## Conclusion

All requirements from `resources/tz.pdf` have been successfully implemented:
- ✅ All 5 main tasks completed
- ✅ All sub-requirements addressed
- ✅ Both XML and programmatic approaches demonstrated
- ✅ Educational examples with clear documentation
- ✅ Interactive demonstrations for learning
- ✅ Proper Android project structure

The project serves as a comprehensive educational resource for learning Android layouts, from basic LinearLayout to advanced ConstraintSet features.
