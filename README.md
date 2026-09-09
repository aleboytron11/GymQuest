# 🎮 GymQuest
## *Transform Your Fitness into an Epic RPG Adventure*

<div align="center">

### 💪 Level Up Through Dedication • 🎯 Earn XP for Every Rep • 🧙‍♂️ Build Your Character

**A gamified fitness tracking app that makes working out feel like an actual adventure quest.**

[✨ Features](#-features) • [🛠️ Tech Stack](#-tech-stack) • [📸 Screenshots](#-screenshots) • [🚀 Getting Started](#-getting-started) • [📈 Roadmap](#-phase-roadmap)

---

</div>

## 🎯 What is GymQuest?

GymQuest turns your gym sessions into an **RPG progression system**. Every workout you log isn't just recorded—it's an **XP gain** that levels up your character. Forget boring fitness apps. This is where fitness meets gaming.

### The Problem It Solves
Traditional fitness apps rely on boring dashboards and numbers. Users get discouraged because progress feels invisible. **GymQuest changes that**: every single rep you do matters, every set you complete earns rewards, and your character **visibly levels up** as you grow stronger.

### The Solution
**Gamification Done Right**: Unlike gimmicky fitness apps, GymQuest makes game mechanics *central* to tracking. Your character level = your actual training consistency. One system. One progression. Real motivation.

---

## ✨ Features

### 🏋️ Core Fitness Tracking (Fully Offline)
- ✅ **Log Workouts** — Record exercise name, category, reps, sets, weight
- ✅ **XP System** — Earn `5 XP × reps × sets` per workout  
  - Example: 10 reps × 3 sets = **150 XP earned**
- ✅ **Character Levels** — Auto-level every 1,000 XP  
  - Track your journey from Level 1 → Level 100+
- ✅ **Workout History** — Browse all past workouts with timestamps
- ✅ **Category Filtering** — Filter by: Chest 💪 | Back 🔙 | Legs 🦵 | Arms 💪 | Shoulders ⬆️ | Cardio 🏃 | Core 🎯
- ✅ **Local Database** — 100% offline. Your data never leaves your device.

### 🎮 Gamification Features
- ✅ **Character Avatar** — Visual representation of your fitness journey
- ✅ **XP Progress Bar** — See progress toward next level in real-time
- ✅ **Milestone Achievements** — Unlock achievements at levels 5, 10, 20...
- ✅ **Retro Pixel Aesthetic** — PressStart2P font + neon colors (dark mode optimized)
- ✅ **Daily Quests** — Stay motivated with daily challenges
- ✅ **Level Up Animations** — Celebration popups when you advance

### 🔜 Coming in Phase 2+
- 🎨 **Character Customization** — Design your warrior (skins, armor, weapons)
- 🏆 **Achievement Badges** — Unlock: "100 Push-ups Club", "PR Master", "Week Warrior"
- 🤝 **Community Tab** — Share workouts, find gym partners, challenge friends
- ⌚ **Health Connect Sync** — Verify workouts with wearables (Apple Watch, Fitbit, etc.)
- 📊 **Advanced Analytics** — Charts, PRs, streaks, heatmaps
- 🎵 **Spotify Integration** — Queue workout playlists while you train

---

## 📸 Screenshots

### 🏠 Character Screen - Track Your Progress
![Character Screen](https://via.placeholder.com/300x600?text=Character+Screen)
- **Peasant Novice** to **Soldier Warrior** progression
- Real-time XP progress bar
- Category-specific stat tracking (Strength, Cardio, Flexibility)
- Daily quests with completion tracking

### 📝 Log Workout - Record Your Gains
![Log Workout Screen](https://via.placeholder.com/300x600?text=Log+Workout)
- Quick workout form with category selector
- Real-time XP calculation (5 × reps × sets)
- Support for weight tracking (optional)
- Success feedback with XP earned display

### 📊 Browse Workouts - View History
![Browse Workouts](https://via.placeholder.com/300x600?text=Browse+Workouts)
- Filter by muscle groups (Chest, Back, Legs, Arms, Core, Cardio)
- View all logged workouts with timestamps
- Delete individual workouts
- See exercises with reps, sets, and weight

### 🤝 Community - Connect with Others
![Community Screen](https://via.placeholder.com/300x600?text=Community)
- Join the GymQuest community (Phase 2+)
- Share routines and connect with other players
- Sign in with Google for authentication
- Comment on workouts and share achievements

---

## 🛠️ Tech Stack

### Why These Choices?

| Tech | Why | Benefit |
|------|-----|---------|
| **Kotlin** | Type-safe, null-safe, expressive | 0 NullPointerExceptions |
| **Jetpack Compose** | Modern declarative UI | Reactive, easy to test |
| **MVVM + StateFlow** | Industry standard | Maintainable, testable code |
| **Room Database** | Compile-time SQL verification | Fewer runtime bugs |
| **Coroutines** | Structured concurrency | Non-blocking database ops |

### Full Stack
```
UI Layer
  ↓ (Jetpack Compose + Material Design 3)
ViewModel + State Management
  ↓ (StateFlow + MVVM)
Business Logic
  ↓ (WorkoutViewModel)
Data Layer
  ↓ (Repository + DAO pattern)
Room Database + SQLite
  ↓
Local Device Storage (Encrypted by default)
```

---

## 🚀 Getting Started

### Prerequisites
```
✓ Android Studio Flamingo (2022.2.1+)
✓ Android SDK 34
✓ Kotlin 1.9+
✓ Gradle 8.0+
✓ 5 minutes of free time
```

### 1️⃣ Clone & Setup
```bash
git clone https://github.com/aleboytron11/GymQuest.git
cd GymQuest
```

### 2️⃣ Open in Android Studio
```
File → Open → Select GymQuest folder
Wait for Gradle sync ☕ (2-3 min)
```

### 3️⃣ Build & Run
```bash
# Option A: Click Run in Android Studio (Shift+F10)
# Option B: Use terminal
./gradlew installDebug

# Or build for emulator
./gradlew assembleDebug
```

### 4️⃣ First Workout
1. Tap **"Log"** tab at bottom
2. Enter exercise: `"Bench Press"`
3. Pick category: `💪 Chest`
4. Enter reps: `10` | sets: `3`
5. Optional: weight `225 lbs`
6. **Tap "Log Workout"** → See your XP go **+150** ✨
7. Tap **"Character"** tab → Watch your level progress

---

## 📊 Project Structure

```
GymQuest/
├── app/src/main/java/
│   ├── com/example/gymquest/
│   │   ├── MainActivity.kt                    # App entry point, navigation
│   │   ├── WorkoutViewModel.kt                # State management (MVVM)
│   │   ├── LogWorkoutScreenEnhanced.kt        # Form with validation
│   │   ├── BrowseWorkoutsScreenEnhanced.kt    # History + filtering
│   │   ├── CharacterScreenEnhanced.kt         # Level display + stats
│   │   ├── ExerciseLibraryEnhanced.kt         # Exercise reference
│   │   └── ui/theme/
│   │       ├── Theme.kt                       # Dark theme, colors
│   │       └── PixelFont.kt                   # Retro typography
│   └── data/
│       ├── Workout.kt                         # Room entity (@Entity)
│       ├── WorkoutCategory.kt                 # Enum for categories
│       ├── WorkoutDao.kt                      # Database queries (@Dao)
│       ├── WorkoutDatabase.kt                 # Room database (@Database)
│       └── Converters.kt                      # Type converters
├── build.gradle.kts                           # Dependencies, build config
├── settings.gradle.kts                        # Project structure
└── README.md                                  # You are here 📍
```

---

## 🏗️ Architecture Highlights

### MVVM Pattern
```
User taps "Log Workout"
        ↓
UI calls viewModel.addWorkout()
        ↓
ViewModel launches coroutine
        ↓
DAO inserts to Room database
        ↓
Database emits updated Flow
        ↓
ViewModel updates StateFlow
        ↓
Compose observes StateFlow
        ↓
UI re-renders with new data ✨
```

### Key Design Decisions

#### 1. Local-First Architecture
- **Why**: Privacy, speed, offline-first experience
- **How**: Room database, no authentication needed
- **Benefit**: Instant feedback, no network delays

#### 2. StateFlow for State Management
- **Why**: Reactive, composable, type-safe
- **How**: ViewModel emits `WorkoutUiState` through StateFlow
- **Benefit**: UI always in sync with data

#### 3. Enum for Categories (Not Strings!)
```kotlin
// ❌ Bad: error-prone strings
val category = "chest" // Typo possible, not type-safe

// ✅ Good: compile-time safety
val category = WorkoutCategory.CHEST
```

#### 4. Room Database with Type Converters
- Enum fields automatically serialized
- Compile-time SQL verification
- No manual SQL strings = fewer bugs

---

## 📈 Phase Roadmap

### ✅ Phase 1: MVP (Current)
- [x] Log workouts with full details
- [x] Character level progression
- [x] Workout history browsing
- [x] Category filtering
- [x] Offline-first local database
- [x] Beautiful dark theme
- [x] Daily quests system

### 🎨 Phase 2: Gamification (Next)
- [ ] Character customization screen
- [ ] Achievement/badge unlock system
- [ ] Daily/weekly streak tracking
- [ ] Level-up animations & notifications
- [ ] Leaderboard (local achievements)

### 🤝 Phase 3: Social Features
- [ ] Firebase Authentication
- [ ] Share workout plans
- [ ] Find gym buddies
- [ ] Comment on shared workouts
- [ ] Global leaderboards

### ⌚ Phase 4: Health Integration
- [ ] Health Connect API sync
- [ ] Wearable verification
- [ ] Cross-app workout import
- [ ] "Verified" badge system

### 📊 Phase 5: Advanced Analytics
- [ ] XP/level charts
- [ ] Personal records (PR) tracking
- [ ] Body-part breakdown analysis
- [ ] Workout streak heatmaps
- [ ] 1RM calculators

### 🎵 Phase 6: Polish
- [ ] Spotify playlist integration
- [ ] Dark/light theme toggle
- [ ] Multi-language support
- [ ] Play Store release
- [ ] Companion web dashboard

---

## 🔒 Privacy & Security

### Our Privacy Promise
- ✅ **No account needed** — Use offline by default
- ✅ **No data sharing** — Your workouts stay on your device
- ✅ **No ads or trackers** — This is ad-free
- ✅ **No cloud by default** — Optional sync (when we add cloud features)

> 💡 Even with future cloud features, they'll be *opt-in only*. You control your data.

---

## 🎓 What I Learned Building This

### Android/Kotlin
- ✅ Jetpack Compose (declarative, reactive UI)
- ✅ Room database (type-safe local persistence)
- ✅ ViewModel architecture (proper state management)
- ✅ Coroutines & Flow (async programming done right)
- ✅ Material Design 3 (modern UI patterns)

### Software Architecture
- ✅ MVVM pattern (separation of concerns)
- ✅ Repository pattern (data abstraction)
- ✅ Reactive programming (StateFlow streams)
- ✅ Kotlin type system (prevent bugs at compile-time)

### Best Practices
- ✅ Null safety (0 NPE bugs possible)
- ✅ Immutable data (reliable state)
- ✅ Offline-first design (works without internet)
- ✅ Testable architecture (easy to add tests)

---

## 🤝 Contributing

This started as a **personal portfolio project**, but ideas and feedback are welcome!

Found a bug? Have a feature idea?
- Open an issue on GitHub
- Submit a pull request
- Reach out: aleboytron11@gmail.com

---

## 📝 License

MIT License — Use this code for learning, projects, or as a template!

```
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without not limited to the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software...
```

See [LICENSE](LICENSE) for full text.

---

## 👋 Let's Connect

Built by **Alejandro** with ❤️

- 💼 **GitHub** [@aleboytron11](https://github.com/aleboytron11)
- 📧 **Email** aleboytron11@gmail.com
- 🐦 **Let's chat** about Android, Kotlin, or fitness!

---

<div align="center">

### 🎮 *Now stop reading and start logging those workouts!* 🎮

**Your character is waiting. Level up. 🚀**

</div>
