# Implementation Summary - Lab 6: Android Layouts

## Overview
This project successfully implements all 5 tasks from the laboratory assignment (`resources/tz.pdf`) on Android Studio layouts.

## What Was Implemented

### ✅ Task 1: LinearLayout with FrameLayout
**Files:**
- `app/src/main/java/com/nau/lab6/Task1LinearLayoutActivity.kt`
- `app/src/main/res/layout/activity_task1_linearlayout.xml`

**Implementation Details:**
- Nested LinearLayout structure with vertical and horizontal orientations
- Header section with horizontal LinearLayout containing TextView and Button
- Middle section split into two columns:
  - Left column: Vertical LinearLayout with buttons and content
  - Right column: FrameLayout demonstrating layer stacking
- FrameLayout shows 3 overlapping layers:
  - Background TextView (semi-transparent)
  - Middle ImageView layer
  - Top TextView layer with styling
- Footer section with vertical LinearLayout
- Demonstrates layout_weight for proportional sizing

### ✅ Task 2: RelativeLayout
**Files:**
- `app/src/main/java/com/nau/lab6/Task2RelativeLayoutActivity.kt`
- `app/src/main/res/layout/activity_task2_relativelayout.xml`

**Implementation Details:**
- Elements positioned relative to parent container:
  - `alignParentTop`, `alignParentBottom`
  - `alignParentStart`, `alignParentEnd`
  - `centerInParent`, `centerVertical`, `centerHorizontal`
- Elements positioned relative to other elements:
  - `layout_below`, `layout_above`
  - `layout_toStartOf`, `layout_toEndOf`
  - `alignTop`, `alignBottom`
- Demonstrates complex positioning without nested layouts
- All interactive elements have click listeners

### ✅ Task 3: Dynamic Manipulation with Kotlin Code
**Files:**
- `app/src/main/java/com/nau/lab6/Task3DynamicActivity.kt`
- `app/src/main/res/layout/activity_task3_dynamic.xml`

**Implementation Details:**
- Uses RelativeLayout as base
- Button triggers dynamic repositioning of TextView
- Implementation demonstrates:
  - Removing views from layout: `rootLayout.removeView(view)`
  - Creating new LayoutParams programmatically
  - Adding layout rules via code: `params.addRule()`
  - Re-adding views with new parameters
- Cycles through 5 different positions:
  1. Center (initial)
  2. Top Left
  3. Bottom Right
  4. Next to top reference button
  5. Next to bottom reference button
- Shows Toast messages to indicate position changes

### ✅ Task 4: ConstraintLayout
**Files:**
- `app/src/main/java/com/nau/lab6/Task4ConstraintLayoutActivity.kt`
- `app/src/main/res/layout/activity_task4_constraintlayout.xml`

**Implementation Details:**
- Demonstrates modern ConstraintLayout approach
- Key features:
  - Parent constraints (constraintTop_toTopOf, constraintStart_toStartOf, etc.)
  - Element-to-element constraints
  - Centering elements using opposing constraints
  - Guidelines (vertical guideline at 30%)
  - Nested LinearLayout within ConstraintLayout
- Advantages over RelativeLayout highlighted in Toast message:
  - Flatter hierarchy
  - Better performance
  - More flexible positioning options
- Same functionality as Task 2 but with ConstraintLayout

### ✅ Task 5: ConstraintSet Advanced Features
**Files:**
- `app/src/main/java/com/nau/lab6/Task5ConstraintSetActivity.kt`
- `app/src/main/res/layout/activity_task5_constraintset.xml`
- `app/src/main/res/xml/constraint_set_alternative.xml` (XML-based ConstraintSet)

**Implementation Details:**

#### 1. Chains
- Creates horizontal chain with 3 buttons
- Uses `ConstraintSet.createHorizontalChain()`
- Chain style: CHAIN_SPREAD (evenly distributed)
- Toggle button to create/remove chain

#### 2. Barriers
- Creates Barrier programmatically using `Barrier` class
- Barrier positioned at the END of referenced views
- Dependent element positioned relative to barrier
- Demonstrates dynamic positioning based on largest element
- Toggle button to create/remove barrier

#### 3. Circle Constraints
- Positions 4 buttons in a circle around center point
- Uses `constraintSet.constrainCircle(elementId, centerId, radius, angle)`
- Angles: 0°, 90°, 180°, 270° for perfect circle
- Radius: 150 pixels
- Toggle button to create/remove circle constraints

#### 4. Groups
- Creates Group programmatically
- Groups 2 TextViews for collective visibility control
- Toggle button shows/hides entire group at once
- Uses `Group.referencedIds` array

#### 5. XML-based ConstraintSet
- Alternative approach demonstrated in `constraint_set_alternative.xml`
- Shows how constraints can be defined in XML and loaded programmatically
- Can be used with `constraintSet.load(context, R.xml.constraint_set_alternative)`

## Project Structure

```
NAU-kotlin-lab6/
├── app/
│   ├── build.gradle                      # App-level Gradle config
│   ├── proguard-rules.pro               # ProGuard rules
│   └── src/main/
│       ├── AndroidManifest.xml          # App manifest
│       ├── java/com/nau/lab6/
│       │   ├── MainActivity.kt          # Main menu
│       │   ├── Task1LinearLayoutActivity.kt
│       │   ├── Task2RelativeLayoutActivity.kt
│       │   ├── Task3DynamicActivity.kt
│       │   ├── Task4ConstraintLayoutActivity.kt
│       │   └── Task5ConstraintSetActivity.kt
│       └── res/
│           ├── layout/                   # All layout XML files
│           ├── values/                   # Colors and strings
│           └── xml/                      # ConstraintSet XML
├── build.gradle                          # Project-level Gradle config
├── settings.gradle                       # Gradle settings
├── gradle.properties                     # Gradle properties
└── README.md                             # Documentation

```

## Key Features

### MainActivity
- Entry point with menu buttons
- Launches each task activity
- Demonstrates programmatic layout creation

### Color Scheme
- Consistent color palette across all tasks
- Colors defined in `res/values/colors.xml`
- Uses Material Design color naming conventions

### Interactive Elements
- All buttons have click listeners
- Toast messages for user feedback
- Dynamic UI updates in Task 3 and Task 5

## Technical Details

### Minimum Requirements
- **minSdk**: 24 (Android 7.0 Nougat)
- **targetSdk**: 34 (Android 14)
- **compileSdk**: 34

### Dependencies
- `androidx.core:core-ktx:1.12.0`
- `androidx.appcompat:appcompat:1.6.1`
- `com.google.android.material:material:1.11.0`
- `androidx.constraintlayout:constraintlayout:2.1.4`

### Build Configuration
- Kotlin JVM target: 1.8
- View binding enabled
- ProGuard configuration for release builds

## How to Build and Run

1. **Prerequisites:**
   - Android Studio Arctic Fox or later
   - Android SDK 24 or higher
   - Gradle 8.7 or later

2. **Open Project:**
   ```bash
   # Open in Android Studio
   File > Open > Select project directory
   ```

3. **Sync Gradle:**
   - Android Studio will prompt to sync Gradle files
   - Click "Sync Now"

4. **Run:**
   - Select a device/emulator
   - Click Run (▶) button
   - Or use: Run > Run 'app'

## Learning Outcomes Achieved

✅ Understanding of LinearLayout nesting and weight distribution  
✅ Mastery of RelativeLayout positioning rules  
✅ Ability to manipulate layouts programmatically with Kotlin  
✅ Proficiency with modern ConstraintLayout  
✅ Advanced ConstraintSet techniques (chains, barriers, groups, circles)  
✅ Comparison of different layout approaches  
✅ Best practices for Android UI development  

## Comparison: RelativeLayout vs ConstraintLayout

### RelativeLayout
- **Pros:** Simple for basic relative positioning, easy to understand
- **Cons:** Can require nested layouts, less flexible

### ConstraintLayout
- **Pros:** Flat hierarchy, better performance, more flexible, powerful editor support
- **Cons:** More complex XML initially, steeper learning curve

**Recommendation:** Use ConstraintLayout for new projects as it's the modern standard.

## Additional Notes

- All code is well-commented for educational purposes
- Each activity demonstrates specific concepts from the lab requirements
- The project structure follows Android best practices
- Resource strings are externalized for maintainability
- Color scheme is consistent and defined centrally

## Reference

For detailed theoretical information and original task requirements, see:
- `resources/tz.pdf` - Original laboratory assignment (Ukrainian)

---

**Project Status:** ✅ Complete - All 5 tasks implemented and documented
