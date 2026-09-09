# GymQuest

**A gamified fitness tracking app for Android that turns your workouts into an RPG adventure. Log exercises, earn XP, level up your character, and build an unstoppable fitness habit.**

---

## Overview

GymQuest reimagines fitness tracking by combining workout logging with RPG game mechanics. Every exercise you log earns XP that contributes to your character's level progression. The app works entirely offline—your workout data stays on your device by default. Optional features like Health Connect integration and Community sharing are available if you want them, but they're never required.

**Key Innovation:** While fitness apps typically use gamification as a gimmick, GymQuest makes the game mechanics inseparable from the tracking system. Your character level directly reflects your training consistency, making progress feel real and rewarding.

---

## Features

### Core Fitness Tracking (Offline, Always)
- ✅ **Log Workouts** - Record exercise name, category, reps, sets, and weight
- ✅ **XP System** - Earn 5 XP per rep × sets (e.g., 3 sets × 10 reps = 150 XP)
- ✅ **Character Progression** - Your character automatically levels up as you accumulate XP (1 level per 1,000 XP)
- ✅ **Workout History** - Browse all your logged workouts with timestamps
- ✅ **Category Browsing** - Filter workouts by muscle group (Chest, Back, Legs, Arms, Shoulders, Cardio, Core)
- ✅ **Local Database** - All data stored securely on your device using Room database

### Coming Soon
- 🎮 **Character Customization** - Design your character's appearance and gear
- 🏆 **Achievement System** - Unlock badges for fitness milestones
- 🤝 **Community Tab** - Share routines, find workout partners, and discuss fitness
- 💪 **Health Connect Integration** - Verify workouts against wearable data for a "Verified" badge
- 📊 **Advanced Analytics** - Track trends, PR records, and workout streaks
- 🎵 **Music Integration** - Link Spotify playlists to your workout routines

---

## Screenshots

*[To be added once app is fully functional]*

---

## Technologies Used

### Android & Kotlin
- **Language:** Kotlin (100% - type-safe, null-safe, expressive)
- **Android Minimum API:** 24 (Android 7.0)
- **Target API:** 34 (Android 14)

### Architecture & Patterns
- **MVVM Architecture** - Clean separation of concerns with ViewModel handling state
- **Repository Pattern** - Data layer abstraction for easy testing and maintenance
- **StateFlow** - Reactive state management for UI updates

### Database
- **Room Database** - Local persistence with compile-time SQL verification
- **SQLite** - Lightweight, efficient, no external dependencies
- **Type Converters** - Custom converters for enum serialization

### UI Framework
- **Jetpack Compose** - Modern declarative UI toolkit
- **Material Design 3** - Contemporary UI components and guidelines
- **Custom Typography** - PressStart2P pixel art font for retro aesthetic

### Libraries & Dependencies
- **Kotlin Coroutines** - Async operations without callbacks
- **Lifecycle Components** - ViewModels survive configuration changes
- **Material3 Components** - Industry-standard UI patterns
- **AndroidX** - Modern Android support libraries

---

## Architecture

### Project Structure
```
app/src/main/java/
├── com/example/gymquest/          # Main app package
│   ├── WorkoutViewModel.kt        # MVVM state management
│   ├── CharacterScreen.kt         # Character progression UI
│   ├── LogWorkoutScreen.kt        # Workout logging form
│   ├── BrowseWorkoutsScreen.kt    # Workout history & filtering
│   ├── ExerciseLibrary.kt         # Exercise reference
│   └── ui/theme/                  # UI customization
│       └── PixelFont.kt           # Retro pixel art typography
└── data/                          # Database layer
    ├── Workout.kt                 # Room entity model
    ├── WorkoutCategory.kt         # Exercise category enum
    ├── WorkoutDao.kt              # Database access object
    ├── WorkoutDatabase.kt         # Room database instance
    └── Converters.kt              # Type converters
```

### Data Flow
```
UI Layer (Compose)
       ↓ (observes StateFlow)
ViewModel (WorkoutViewModel)
       ↓ (calls suspend functions)
Repository/DAO (WorkoutDao)
       ↓ (queries)
Room Database (SQLite)
       ↓
Local Device Storage
```

### Key Design Decisions

**1. MVVM with StateFlow**
- UI observes `WorkoutUiState` via `StateFlow`
- ViewModel handles business logic and data operations
- Coroutines manage async database operations safely
- State is preserved across configuration changes (screen rotation, etc.)

**2. Local-First Architecture**
- All workout data stored locally by default
- No required cloud services or account creation
- Optional Firebase integration for Community features (planned)
- Privacy-by-design approach

**3. Room Database**
- Type-safe database queries (compiled at build time)
- Automatic migrations support (future versions)
- Efficient queries with Flow for reactive updates
- No manual SQL strings = fewer runtime errors

**4. Enum for Categories**
- Type-safe category selection (not error-prone strings)
- Custom display names and emojis for UI
- Easy to extend with new categories
- Serializable for database storage

---

## Getting Started

### Prerequisites
- Android Studio Flamingo (2022.2.1) or newer
- Android SDK 34
- Kotlin 1.9+
- Gradle 8.0+

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/aleboytron11/GymQuest.git
   cd GymQuest
   ```

2. **Open in Android Studio**
   - File → Open → Select GymQuest folder
   - Wait for Gradle sync to complete

3. **Build and Run**
   ```bash
   # Via Android Studio: Click "Run" (Shift+F10)
   # Via Gradle:
   ./gradlew installDebug
   ```

4. **Emulator or Device**
   - Ensure Android Emulator is running or physical device is connected
   - App will launch automatically after build completes

### First Steps
1. Navigate to "Log Workout" tab
2. Enter an exercise name (e.g., "Bench Press")
3. Select category (e.g., "Chest")
4. Enter reps and sets (e.g., 10 reps, 3 sets)
5. Optionally enter weight
6. Tap "Log Workout" to save
7. Watch your XP increase and character level up!

---

## What I Learned

### Android Development
- **Jetpack Compose** - Building declarative UIs with functional programming paradigms
- **Room Database** - Efficient local data persistence with compile-time verification
- **ViewModel Architecture** - Proper state management that survives configuration changes
- **Coroutines & Flow** - Asynchronous programming without callback hell

### Software Architecture
- **MVVM Pattern** - Separating UI logic from business logic for testability
- **Repository Pattern** - Abstracting data sources for flexibility
- **Reactive Programming** - Building responsive apps with Stream-based state management
- **Type Safety in Kotlin** - Leveraging the type system to prevent runtime errors

### Best Practices
- **Null Safety** - Using Kotlin's null-safety features to eliminate NPEs
- **Immutable Data** - Data classes for reliable state management
- **Separation of Concerns** - Each layer has a single responsibility
- **Offline-First Design** - Designing apps that work without internet

### Project Management
- **Git Workflow** - Committing changes with clear, descriptive messages
- **Documentation** - Writing README and code comments for future developers
- **Testing Strategy** - Planning testable code architecture (tests pending)

---

## Future Improvements

### Phase 2: Gamification
- [ ] Character customization (skin color, outfit, class)
- [ ] Achievement/badge system (e.g., "100 Push-ups Club")
- [ ] Daily/weekly streak tracking
- [ ] Character progression milestones (unlock perks at levels 5, 10, 20)
- [ ] XP multipliers for specific workout types

### Phase 3: Community & Social
- [ ] Firebase Authentication (Google sign-in)
- [ ] Community tab for sharing routines
- [ ] Follow other users and compare progress
- [ ] Comments and reactions on shared routines
- [ ] Leaderboards by category or total XP

### Phase 4: Health Integration
- [ ] Health Connect API integration
- [ ] Read exercise sessions from wearables/other fitness apps
- [ ] "Verified" badge for workouts matching wearable data
- [ ] Import historical workout data

### Phase 5: Advanced Analytics
- [ ] Charts for XP over time
- [ ] Personal records (PR) tracking by exercise
- [ ] Workout frequency heatmap
- [ ] Body part frequency analysis
- [ ] Estimated 1RM calculations

### Phase 6: Polish & Optimization
- [ ] Unit tests (ViewModel, database queries)
- [ ] UI tests (Compose test suite)
- [ ] Performance profiling (RAM, battery usage)
- [ ] Accessibility features (screen reader support, color contrast)
- [ ] Play Store release with proper signing

---

## Privacy & Security

All workout data is stored locally on your device and never leaves unless you explicitly enable optional features. See [Privacy Policy](docs/privacy-policy.html) for detailed information about:
- What data is collected
- Where it's stored
- What happens with optional features (Health Connect, Community)
- Data deletion options

**TL;DR:** Your fitness data is yours. We don't track you, sell your data, or require an account.

---

## Contributing

This is a personal portfolio project, but feedback and suggestions are welcome! If you find a bug or have ideas for features, open an issue on GitHub.

---

## License

This project is open source and available under the MIT License. See LICENSE file for details.

---

## Contact

Questions? Reach out:
- **Email:** aleboytron11@gmail.com
- **GitHub:** [@aleboytron11](https://github.com/aleboytron11)

---

## Acknowledgments

- **Press Start 2P Font** - For the retro pixel-art aesthetic
- **Material Design 3** - For modern, accessible UI guidelines
- **Google Fonts** - For free, open-source typography
- **Android Developers Community** - For excellent documentation and support

---

**Built with ❤️ as a portfolio project to demonstrate Android development skills.**

*Last Updated: September 2026*
