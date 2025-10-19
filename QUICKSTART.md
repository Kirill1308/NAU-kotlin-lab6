# Quick Start Guide

Get up and running with Lab 6 - Android Layouts in minutes!

## Prerequisites

Before you begin, ensure you have:
- ✅ Android Studio (Arctic Fox or later)
- ✅ JDK 8 or higher
- ✅ Android SDK Platform 24 or higher
- ✅ An Android emulator or physical device

## Setup

### 1. Open the Project

```bash
# Method 1: Using Android Studio GUI
# File > Open > Navigate to project directory > Open

# Method 2: From command line
cd /path/to/NAU-kotlin-lab6
# Then open Android Studio and select this directory
```

### 2. Sync Gradle

After opening the project:
1. Android Studio will detect Gradle files
2. A notification bar will appear: "Gradle files have changed..."
3. Click **"Sync Now"**
4. Wait for Gradle sync to complete (first time may take a few minutes)

### 3. Configure Device

**Option A: Emulator**
1. Tools > Device Manager
2. Click "Create Device"
3. Choose a device (e.g., Pixel 4)
4. Download a system image (API 24 or higher)
5. Click "Finish"

**Option B: Physical Device**
1. Enable Developer Options on your Android device
2. Enable USB Debugging
3. Connect device via USB
4. Accept the debugging prompt on your device

## Running the App

### From Android Studio

1. Click the ▶ **Run** button (or press Shift+F10)
2. Select your target device
3. Wait for build to complete
4. App will launch automatically

### From Command Line

```bash
# Build the project
./gradlew assembleDebug

# Install on connected device
./gradlew installDebug

# Or combine both
./gradlew installDebug
```

## Exploring the Tasks

Once the app launches, you'll see the main menu with 5 buttons:

### 1️⃣ Task 1: LinearLayout + FrameLayout
- **What to try:** Observe nested layouts and overlapping FrameLayout layers
- **Interactive elements:** Click any button to see Toast messages
- **Learning focus:** Nesting, layout_weight, layer stacking

### 2️⃣ Task 2: RelativeLayout
- **What to try:** Notice how elements are positioned relative to each other
- **Interactive elements:** Click buttons positioned around the screen
- **Learning focus:** Relative positioning, no nesting needed

### 3️⃣ Task 3: Dynamic Manipulation
- **What to try:** Click "Move Component" button repeatedly
- **Interactive elements:** Watch the TextView move to 5 different positions
- **Learning focus:** Programmatic layout manipulation

### 4️⃣ Task 4: ConstraintLayout
- **What to try:** Compare with Task 2, notice the guideline at 30%
- **Interactive elements:** Click buttons, see comparison Toast message
- **Learning focus:** Modern layout approach, flat hierarchy

### 5️⃣ Task 5: ConstraintSet
- **What to try:** Toggle each of the 4 features independently
- **Interactive elements:** 
  - "Create Chain" → Distributes 3 buttons evenly
  - "Create Barrier" → Shows dynamic positioning
  - "Circle Constraint" → Arranges 4 buttons in a circle
  - "Toggle Group" → Shows/hides 2 elements together
- **Learning focus:** Advanced ConstraintLayout features

## Troubleshooting

### Gradle Sync Failed

**Problem:** "Plugin with id 'com.android.application' not found"

**Solution:**
1. Check internet connection
2. File > Invalidate Caches and Restart
3. Update Android Studio to latest version
4. Check `build.gradle` files are correct

### Build Error: SDK Not Found

**Problem:** "SDK location not found"

**Solution:**
1. Open SDK Manager (Tools > SDK Manager)
2. Install Android SDK Platform 24 or higher
3. Install Build Tools
4. Sync Gradle again

### App Crashes on Launch

**Problem:** App crashes immediately after launch

**Solution:**
1. Check Logcat for error messages (View > Tool Windows > Logcat)
2. Verify minimum SDK version (API 24)
3. Clean and rebuild: Build > Clean Project, then Build > Rebuild Project

### No Devices Available

**Problem:** No emulator or device appears in device list

**Solution:**
- For Emulator: Tools > Device Manager > Create Device
- For Physical Device: Enable USB Debugging in Developer Options

## Project Structure Quick Reference

```
NAU-kotlin-lab6/
├── app/
│   ├── src/main/
│   │   ├── AndroidManifest.xml          ← Activities declared here
│   │   ├── java/com/nau/lab6/           ← Kotlin source files
│   │   │   ├── MainActivity.kt          ← START HERE
│   │   │   ├── Task1...Activity.kt
│   │   │   ├── Task2...Activity.kt
│   │   │   ├── Task3...Activity.kt
│   │   │   ├── Task4...Activity.kt
│   │   │   └── Task5...Activity.kt
│   │   └── res/
│   │       ├── layout/                   ← XML layouts
│   │       ├── values/                   ← Strings, colors
│   │       └── xml/                      ← ConstraintSet XML
│   └── build.gradle                      ← App dependencies
├── build.gradle                          ← Project config
└── README.md                             ← Documentation
```

## Understanding the Code

### Layout XML Files
Each task has a corresponding XML layout file:
- `activity_task1_linearlayout.xml` → Task 1
- `activity_task2_relativelayout.xml` → Task 2
- `activity_task3_dynamic.xml` → Task 3
- `activity_task4_constraintlayout.xml` → Task 4
- `activity_task5_constraintset.xml` → Task 5

**How to view:**
1. Open in Android Studio
2. Switch between "Code" and "Design" tabs at the top
3. Use "Split" view to see both simultaneously

### Kotlin Activity Files
Each task has a Kotlin activity:
- Located in `app/src/main/java/com/nau/lab6/`
- Named `Task[N]...Activity.kt`

**Key methods:**
- `onCreate()` → Called when activity starts
- `setContentView(R.layout.xxx)` → Sets the XML layout
- `findViewById<T>(R.id.xxx)` → Gets reference to view

## Modifying the Code

### Change Colors
1. Open `app/src/main/res/values/colors.xml`
2. Modify color values (format: `#AARRGGBB`)
3. Save and rebuild

### Change Text
1. Open `app/src/main/res/values/strings.xml`
2. Modify string values
3. Save and rebuild

### Modify Layouts
1. Open any layout XML file
2. Edit in "Design" mode (visual) or "Code" mode (XML)
3. Save and rerun the app

### Add New Features
1. Open relevant Activity file
2. Add code in `onCreate()` method
3. Save and rerun the app

## Learning Path

**Recommended order for studying:**

1. **Start:** Read `README.md` for overview
2. **Understand:** Read `TASKS_OVERVIEW.md` for visual explanations
3. **Explore:** Open each XML layout file and study the structure
4. **Run:** Launch the app and interact with each task
5. **Modify:** Make small changes and observe the results
6. **Deep Dive:** Read `IMPLEMENTATION_SUMMARY.md` for details
7. **Reference:** Check `REQUIREMENT_MAPPING.md` to understand requirements

## Tips for Learning

### 1. Compare Layouts
Open Task 2 (RelativeLayout) and Task 4 (ConstraintLayout) side by side to see different approaches to similar layouts.

### 2. Use Design Mode
Switch to "Design" mode in XML editor to visually see the layout structure.

### 3. Experiment
Try changing values and see what happens:
- Change `layout_width` from `wrap_content` to `match_parent`
- Adjust margins and padding
- Modify constraint rules
- Add new elements

### 4. Read Comments
All code files contain detailed comments explaining key concepts.

### 5. Check Logcat
View > Tool Windows > Logcat shows runtime messages and errors.

## Keyboard Shortcuts (Android Studio)

- **Run app:** Shift+F10
- **Debug app:** Shift+F9
- **Find file:** Ctrl+Shift+N (Cmd+Shift+O on Mac)
- **Find in file:** Ctrl+F (Cmd+F on Mac)
- **Auto-format code:** Ctrl+Alt+L (Cmd+Option+L on Mac)
- **Quick documentation:** Ctrl+Q (F1 on Mac)

## Next Steps

After completing the quick start:

1. ✅ Run all 5 tasks
2. ✅ Understand each layout type
3. ✅ Modify layouts and observe changes
4. ✅ Read the detailed documentation
5. ✅ Experiment with your own layouts

## Getting Help

If you need help:

1. **Documentation:** Check README.md and other .md files
2. **Code Comments:** Read comments in source files
3. **Android Docs:** https://developer.android.com/guide/topics/ui/declaring-layout
4. **Stack Overflow:** Search for specific error messages

## Summary

You're now ready to explore Android layouts! 🚀

1. Open the project in Android Studio
2. Sync Gradle
3. Run the app
4. Explore each of the 5 tasks
5. Modify and experiment

Happy learning! 📱
