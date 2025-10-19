# Lab 6 Tasks Overview

This document provides a visual overview of what each task demonstrates.

## Task 1: LinearLayout with FrameLayout

```
┌──────────────────────────────────────────────────────────┐
│  [Header Text]                           [Button 1]      │ ← Horizontal LinearLayout
├──────────────────────────────────────────────────────────┤
│                                                          │
│  ┌──────────────────┐  ┌──────────────────────────────┐ │
│  │  [Button 2]      │  │ ┌─ Background Layer          │ │
│  │                  │  │ │  (TextView)                 │ │
│  │  [Button 3]      │  │ │  ┌─ Middle Layer           │ │
│  │                  │  │ │  │  (ImageView)             │ │ ← FrameLayout
│  │  Left Column     │  │ │  │  ┌─ Top Layer           │ │   (overlapping)
│  │  Content         │  │ │  │  │  "FrameLayout        │ │
│  │                  │  │ │  │  │   Top Layer"         │ │
│  │                  │  │ └──┘  └──────────────────────┘ │
│  └──────────────────┘  └──────────────────────────────┘ │
│      ↑ Vertical            ↑ FrameLayout with          │
│        LinearLayout          3 overlapping layers      │
├──────────────────────────────────────────────────────────┤
│  Footer Text                                            │
│  [Button 4 - Full Width]                                │ ← Vertical LinearLayout
└──────────────────────────────────────────────────────────┘
```

**Key Concepts:**
- Nested LinearLayouts (vertical and horizontal)
- layout_weight for proportional sizing
- FrameLayout for layering/stacking views
- Proper use of padding and margins

---

## Task 2: RelativeLayout

```
┌──────────────────────────────────────────────────────────┐
│  [Top Left]                           [Top Right]        │
│   ↑ alignParentTop                     ↑ alignParentTop  │
│   ↑ alignParentStart                   ↑ alignParentEnd  │
│                                                          │
│              [Above Center]                              │
│                    ↓ above centerTextView                │
│                                                          │
│  [Left] [←] ╔═══════════════════╗ [→] [Right]          │
│   ↑           ║  CENTER CONTENT  ║          ↑            │
│   |           ║  centerInParent  ║          |            │
│   |           ╚═══════════════════╝          |            │
│   |                   ↓                      |            │
│   alignParentStart    [Below Center]   alignParentEnd   │
│   centerVertical      ↑ below centerTextView             │
│                       ↑ centerHorizontal                 │
│                                                          │
│  [Bottom Left]                        [Bottom Right]    │
│   ↑ alignParentBottom                  ↑ alignParentBottom│
│   ↑ alignParentStart                   ↑ alignParentEnd  │
└──────────────────────────────────────────────────────────┘
```

**Key Concepts:**
- Relative positioning to parent (alignParent*)
- Relative positioning to siblings (layout_above, layout_below, etc.)
- Centering (centerInParent, centerHorizontal, centerVertical)
- No nested layouts needed!

---

## Task 3: Dynamic Manipulation

```
Initial State:
┌──────────────────────────────────────────────────────────┐
│  [Move Component Button]                                 │
├──────────────────────────────────────────────────────────┤
│  [Top Left Ref]                                          │
│                                                          │
│  Instructions: Click 'Move Component' to...              │
│                                                          │
│                    ╔═══════════════╗                     │
│                    ║  I will move! ║ ← movableTextView   │
│                    ╚═══════════════╝                     │
│                                                          │
│                                 [Bottom Right Ref]       │
└──────────────────────────────────────────────────────────┘

After Clicking (cycles through 5 positions):
1. Center (initial)
2. Top Left (below Move Button)
3. Bottom Right
4. Next to Top Left Ref
5. Next to Bottom Right Ref
```

**Key Concepts:**
- `removeView()` - removing views from layout
- Creating `RelativeLayout.LayoutParams` programmatically
- `addRule()` - adding positioning rules in code
- `addView()` - adding views back with new parameters
- Dynamic UI updates based on user interaction

---

## Task 4: ConstraintLayout

```
┌──────────────────────────────────────────────────────────┐
│  ════════════════ HEADER ═══════════════════════        │
│   ↑ constraintTop_toTopOf="parent"                      │
│   ↑ constraintStart/End_toStart/EndOf="parent"          │
├──────────────────────────────────────────────────────────┤
│  [Top Left]                           [Top Right]        │
│   ↑ below header                       ↑ below header    │
│                                                          │
│  [At 30%]  ← aligned to guideline (30%)                 │
│                                                          │
│              [Above Center]                              │
│                    ↓                                     │
│  [Left] ═══ ╔═══════════════════╗ ═══ [Right]          │
│             ║  CENTER CONTENT   ║                       │
│             ║  centered with    ║                       │
│             ║  opposing         ║                       │
│             ║  constraints      ║                       │
│             ╚═══════════════════╝                       │
│                    ↑                                     │
│              [Below Center]                              │
│                                                          │
│  ════════════════ FOOTER ════════════════════           │
│  [Button 1]              [Button 2]                     │
│   ↑ constraintBottom_toBottomOf="parent"                │
└──────────────────────────────────────────────────────────┘
```

**Key Concepts:**
- Constraint-based positioning (not rule-based like RelativeLayout)
- Guidelines for alignment
- Opposing constraints for centering
- Flat view hierarchy (better performance)
- More flexible than RelativeLayout

**Comparison with Task 2:**
- Similar visual result, different implementation
- ConstraintLayout: more flexible, better for complex UIs
- RelativeLayout: simpler for basic relative positioning

---

## Task 5: ConstraintSet - Advanced Features

### Feature 1: Chains
```
Before:                   After Chain Created:
[C1]                     [C1]═══[C2]═══[C3]
[C2]                      ↑    ↑    ↑    ↑
[C3]                      └────┴────┴────┘
                         Evenly distributed
                         across parent width
```

### Feature 2: Barriers
```
[Short]           |  ← Barrier (positioned at END of longest)
[Much Longer Text]|
                  |
                  └──→ [I'm after barrier]
                       Always starts after
                       the longest element
```

### Feature 3: Circle Constraints
```
                    [1]
                     │ 0°
                     │
           [4] ──────●────── [2]
          270°   (center)   90°
                     │
                     │180°
                    [3]

All elements positioned at:
- Same radius (150px)
- Different angles (0°, 90°, 180°, 270°)
```

### Feature 4: Groups
```
Before Toggle:              After Toggle:
[Group 1]  [Group 2]       [          ]  [          ]
  visible    visible          hidden       hidden

Both elements shown/hidden together
using Group.visibility
```

**Key Concepts:**
- **Chains**: Distribute elements evenly (spread, spread_inside, packed)
- **Barriers**: Dynamic positioning based on multiple elements
- **Circle Constraints**: Radial positioning around a center point
- **Groups**: Control visibility of multiple views together
- **ConstraintSet**: Programmatic constraint manipulation
- **XML ConstraintSet**: Define constraints in XML, load in code

---

## Activity Flow

```
┌─────────────────────┐
│   MainActivity      │
│  (Menu with 5      │
│   task buttons)    │
└─────────────────────┘
         │
         ├──→ Task 1: LinearLayout + FrameLayout
         │
         ├──→ Task 2: RelativeLayout
         │
         ├──→ Task 3: Dynamic Manipulation
         │
         ├──→ Task 4: ConstraintLayout
         │
         └──→ Task 5: ConstraintSet Features
```

## File Organization

```
app/src/main/
├── java/com/nau/lab6/
│   ├── MainActivity.kt                      (Menu)
│   ├── Task1LinearLayoutActivity.kt         (Task 1)
│   ├── Task2RelativeLayoutActivity.kt       (Task 2)
│   ├── Task3DynamicActivity.kt              (Task 3)
│   ├── Task4ConstraintLayoutActivity.kt     (Task 4)
│   └── Task5ConstraintSetActivity.kt        (Task 5)
│
└── res/
    ├── layout/
    │   ├── activity_task1_linearlayout.xml
    │   ├── activity_task2_relativelayout.xml
    │   ├── activity_task3_dynamic.xml
    │   ├── activity_task4_constraintlayout.xml
    │   └── activity_task5_constraintset.xml
    │
    ├── values/
    │   ├── colors.xml        (Color definitions)
    │   └── strings.xml       (String resources)
    │
    └── xml/
        └── constraint_set_alternative.xml  (XML ConstraintSet)
```

## Learning Progression

1. **Task 1**: Basic layouts → nested structures
2. **Task 2**: Relative positioning → eliminating nesting
3. **Task 3**: Static XML → dynamic code manipulation
4. **Task 4**: Modern layouts → better performance
5. **Task 5**: Advanced features → professional techniques

Each task builds upon the previous, progressively introducing more advanced concepts.

---

## Testing Each Task

### Task 1
- ✅ Verify nested LinearLayouts render correctly
- ✅ Check FrameLayout shows all 3 layers
- ✅ Confirm buttons are clickable and show toasts

### Task 2
- ✅ Verify all elements positioned correctly
- ✅ Check relative positioning works (above, below, etc.)
- ✅ Confirm all buttons are clickable

### Task 3
- ✅ Click "Move Component" multiple times
- ✅ Verify TextView moves to 5 different positions
- ✅ Check toast messages display correctly

### Task 4
- ✅ Compare with Task 2 layout
- ✅ Verify guideline positioning (30%)
- ✅ Check all constraints work correctly

### Task 5
- ✅ Toggle chain creation/removal
- ✅ Toggle barrier creation/removal
- ✅ Toggle circle constraints
- ✅ Toggle group visibility
- ✅ Verify all features work independently

---

**All tasks successfully implemented according to `resources/tz.pdf` requirements!**
