# Lab 6 - Android Layouts: Documentation Index

Welcome! This is your guide to all documentation for Laboratory Work 6.

## 📋 Documentation Files

### 🚀 [QUICKSTART.md](QUICKSTART.md) - START HERE!
**For:** First-time users, students beginning the lab  
**Contents:**
- Setup instructions
- How to run the app
- Quick overview of each task
- Troubleshooting guide
- Keyboard shortcuts

**Start here if you want to:** Get the app running quickly

---

### 📖 [README.md](README.md) - Project Overview
**For:** Understanding the project structure and goals  
**Contents:**
- Project description
- Structure overview
- Each task explained briefly
- Build requirements
- Key learning outcomes

**Read this if you want to:** Understand what the project is about

---

### 🎯 [REQUIREMENT_MAPPING.md](REQUIREMENT_MAPPING.md) - Task Requirements
**For:** Understanding how implementation meets original requirements  
**Contents:**
- Original requirements from `resources/tz.pdf` (in Ukrainian)
- English translations
- Implementation details for each requirement
- Code examples
- Completion checklist

**Read this if you want to:** See how each PDF requirement was implemented

---

### 📊 [TASKS_OVERVIEW.md](TASKS_OVERVIEW.md) - Visual Guide
**For:** Visual learners, understanding layout structures  
**Contents:**
- ASCII diagrams of each layout
- Visual representation of Task 1-5
- Before/after comparisons
- Activity flow diagram
- File organization tree

**Read this if you want to:** See visual diagrams of how layouts work

---

### 🔧 [IMPLEMENTATION_SUMMARY.md](IMPLEMENTATION_SUMMARY.md) - Technical Details
**For:** Developers, code reviewers, deep technical understanding  
**Contents:**
- Detailed implementation of each task
- Code explanations
- Technical specifications
- Dependencies
- Comparison of layout approaches
- Best practices applied

**Read this if you want to:** Understand technical implementation details

---

## 📚 Source Files

### Kotlin Activities
Located in `app/src/main/java/com/nau/lab6/`

| File | Task | Description |
|------|------|-------------|
| `MainActivity.kt` | Menu | Main menu with buttons for each task |
| `Task1LinearLayoutActivity.kt` | Task 1 | LinearLayout + FrameLayout demo |
| `Task2RelativeLayoutActivity.kt` | Task 2 | RelativeLayout positioning |
| `Task3DynamicActivity.kt` | Task 3 | Dynamic layout manipulation |
| `Task4ConstraintLayoutActivity.kt` | Task 4 | ConstraintLayout demo |
| `Task5ConstraintSetActivity.kt` | Task 5 | Advanced ConstraintSet features |

### XML Layouts
Located in `app/src/main/res/layout/`

| File | Description |
|------|-------------|
| `activity_task1_linearlayout.xml` | Nested LinearLayout with FrameLayout |
| `activity_task2_relativelayout.xml` | RelativeLayout with relative positioning |
| `activity_task3_dynamic.xml` | Base layout for dynamic manipulation |
| `activity_task4_constraintlayout.xml` | ConstraintLayout demonstration |
| `activity_task5_constraintset.xml` | Base for ConstraintSet features |

### Resource Files
- `app/src/main/res/values/strings.xml` - String resources
- `app/src/main/res/values/colors.xml` - Color definitions
- `app/src/main/res/xml/constraint_set_alternative.xml` - XML ConstraintSet

---

## 🎓 Learning Path

### For Complete Beginners
1. [QUICKSTART.md](QUICKSTART.md) - Get the app running
2. Run the app and explore each task
3. [TASKS_OVERVIEW.md](TASKS_OVERVIEW.md) - See visual diagrams
4. [README.md](README.md) - Understand the project
5. Modify code and experiment

### For Students Doing the Assignment
1. [REQUIREMENT_MAPPING.md](REQUIREMENT_MAPPING.md) - See requirements
2. [QUICKSTART.md](QUICKSTART.md) - Setup and run
3. Study each task's XML and Kotlin files
4. [IMPLEMENTATION_SUMMARY.md](IMPLEMENTATION_SUMMARY.md) - Technical details
5. Experiment with modifications

### For Code Reviewers
1. [README.md](README.md) - Project overview
2. [REQUIREMENT_MAPPING.md](REQUIREMENT_MAPPING.md) - Requirements coverage
3. [IMPLEMENTATION_SUMMARY.md](IMPLEMENTATION_SUMMARY.md) - Implementation details
4. Review source code files
5. Run the app to verify functionality

---

## 🗺️ Project Structure

```
NAU-kotlin-lab6/
├── 📄 INDEX.md                         ← You are here!
├── 📄 README.md                        ← Start for overview
├── 📄 QUICKSTART.md                    ← Start for setup
├── 📄 REQUIREMENT_MAPPING.md           ← Requirements
├── 📄 TASKS_OVERVIEW.md                ← Visual guide
├── 📄 IMPLEMENTATION_SUMMARY.md        ← Technical details
│
├── 📁 resources/
│   └── tz.pdf                          ← Original assignment (Ukrainian)
│
├── 📁 app/
│   ├── build.gradle                    ← App dependencies
│   ├── proguard-rules.pro              ← ProGuard config
│   │
│   └── 📁 src/main/
│       ├── AndroidManifest.xml         ← App manifest
│       │
│       ├── 📁 java/com/nau/lab6/
│       │   ├── MainActivity.kt         ← Main menu
│       │   ├── Task1LinearLayoutActivity.kt
│       │   ├── Task2RelativeLayoutActivity.kt
│       │   ├── Task3DynamicActivity.kt
│       │   ├── Task4ConstraintLayoutActivity.kt
│       │   └── Task5ConstraintSetActivity.kt
│       │
│       └── 📁 res/
│           ├── 📁 layout/              ← XML layouts
│           ├── 📁 values/              ← Strings, colors
│           └── 📁 xml/                 ← ConstraintSet XML
│
├── build.gradle                        ← Project config
├── settings.gradle                     ← Gradle settings
└── gradle.properties                   ← Gradle properties
```

---

## 🎯 Tasks Quick Reference

### Task 1: LinearLayout + FrameLayout
**File:** `Task1LinearLayoutActivity.kt` + `activity_task1_linearlayout.xml`  
**Features:** Nested layouts, FrameLayout overlay, layout_weight  
**Interactive:** Click buttons to see toasts

### Task 2: RelativeLayout
**File:** `Task2RelativeLayoutActivity.kt` + `activity_task2_relativelayout.xml`  
**Features:** Relative positioning, parent/sibling alignment  
**Interactive:** Click buttons positioned around screen

### Task 3: Dynamic Manipulation
**File:** `Task3DynamicActivity.kt` + `activity_task3_dynamic.xml`  
**Features:** removeView(), addView(), dynamic LayoutParams  
**Interactive:** Click "Move Component" to reposition TextView

### Task 4: ConstraintLayout
**File:** `Task4ConstraintLayoutActivity.kt` + `activity_task4_constraintlayout.xml`  
**Features:** Constraints, guidelines, flat hierarchy  
**Interactive:** Compare with Task 2, explore constraints

### Task 5: ConstraintSet
**File:** `Task5ConstraintSetActivity.kt` + `activity_task5_constraintset.xml`  
**Features:** Chains, barriers, groups, circle constraints  
**Interactive:** Toggle 4 different features with buttons

---

## 🔍 Quick Search

Looking for something specific?

| I want to... | Go to... |
|--------------|----------|
| **Set up the project** | [QUICKSTART.md](QUICKSTART.md) |
| **Understand nested layouts** | Task 1 files + [TASKS_OVERVIEW.md](TASKS_OVERVIEW.md#task-1) |
| **Learn relative positioning** | Task 2 files + [TASKS_OVERVIEW.md](TASKS_OVERVIEW.md#task-2) |
| **See dynamic code manipulation** | Task 3 files + [IMPLEMENTATION_SUMMARY.md](IMPLEMENTATION_SUMMARY.md#task-3) |
| **Compare layouts** | [IMPLEMENTATION_SUMMARY.md](IMPLEMENTATION_SUMMARY.md#comparison) |
| **Use ConstraintSet** | Task 5 files + [REQUIREMENT_MAPPING.md](REQUIREMENT_MAPPING.md#5) |
| **Check requirements** | [REQUIREMENT_MAPPING.md](REQUIREMENT_MAPPING.md) |
| **See visual diagrams** | [TASKS_OVERVIEW.md](TASKS_OVERVIEW.md) |
| **Find code examples** | [IMPLEMENTATION_SUMMARY.md](IMPLEMENTATION_SUMMARY.md) |
| **Troubleshoot issues** | [QUICKSTART.md](QUICKSTART.md#troubleshooting) |

---

## 📝 Lab Assignment Reference

Original assignment: [`resources/tz.pdf`](resources/tz.pdf) (Ukrainian)

**5 Main Tasks:**
1. ✅ LinearLayout вкладення + FrameLayout
2. ✅ RelativeLayout в XML з вирівнюванням
3. ✅ Динамічна маніпуляція за допомогою Java/Kotlin коду
4. ✅ ConstraintLayout в Design та XML + порівняння
5. ✅ ConstraintSet: прив'язки, ланцюжки, бар'єри, групи, constraintCircle

All requirements have been fully implemented! ✨

---

## 💡 Tips

- **New to Android?** Start with [QUICKSTART.md](QUICKSTART.md)
- **Visual learner?** Check out [TASKS_OVERVIEW.md](TASKS_OVERVIEW.md)
- **Need technical details?** Read [IMPLEMENTATION_SUMMARY.md](IMPLEMENTATION_SUMMARY.md)
- **Doing the assignment?** Follow [REQUIREMENT_MAPPING.md](REQUIREMENT_MAPPING.md)

---

## ✅ Completion Checklist

Use this to track your progress:

- [ ] Read QUICKSTART.md
- [ ] Set up project in Android Studio
- [ ] Run the app successfully
- [ ] Explore Task 1 (LinearLayout + FrameLayout)
- [ ] Explore Task 2 (RelativeLayout)
- [ ] Explore Task 3 (Dynamic manipulation)
- [ ] Explore Task 4 (ConstraintLayout)
- [ ] Explore Task 5 (ConstraintSet features)
- [ ] Study XML layout files
- [ ] Study Kotlin activity files
- [ ] Understand all documentation
- [ ] Experiment with modifications

---

## 🚀 Ready to Start?

1. Go to [QUICKSTART.md](QUICKSTART.md)
2. Follow the setup instructions
3. Run the app
4. Explore and learn!

Happy coding! 📱✨
