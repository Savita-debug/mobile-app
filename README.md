# MedAssist - AI-Powered Medication Adherence System (Android)

A Kotlin Android app built with Jetpack Compose for managing medication adherence. Supports both patient and caretaker roles with real-time schedule tracking, prescription scanning, and AI-powered adherence predictions.

## Tech Stack

- **Language:** Kotlin
- **UI:** Jetpack Compose with Material Design 3
- **Architecture:** MVVM (ViewModel + Repository + API/Room)
- **Networking:** Retrofit + OkHttp with JWT auth interceptors
- **Local Storage:** Room database for offline caching
- **Dependency Injection:** Hilt
- **Async:** Kotlin Coroutines + Flow
- **Reminders:** AlarmManager with notification actions
- **Security:** EncryptedSharedPreferences for token storage
- **Navigation:** Navigation Compose with role-based routing

## Project Structure

```
app/src/main/java/com/medassist/app/
├── MedAssistApp.kt              # Application class + notification channel
├── MainActivity.kt              # Single activity entry point
├── data/
│   ├── api/
│   │   ├── ApiService.kt        # Retrofit interface (all endpoints)
│   │   ├── AuthInterceptor.kt   # JWT Bearer token attachment
│   │   └── TokenRefreshInterceptor.kt  # Auto-refresh expired tokens
│   ├── local/
│   │   ├── MedAssistDatabase.kt # Room database
│   │   ├── dao/                 # MedicationDao, ScheduleDao
│   │   └── entity/              # MedicationEntity, ScheduleEntity
│   ├── model/                   # API request/response data classes
│   └── repository/              # AuthRepo, MedicationRepo, AdherenceRepo, etc.
├── di/
│   ├── AppModule.kt             # Room + DAOs
│   └── NetworkModule.kt         # Retrofit + OkHttp
├── ui/
│   ├── navigation/NavGraph.kt   # Routes + role-based navigation
│   ├── auth/                    # Login, Register, AuthViewModel
│   ├── patient/                 # Dashboard, Medications, Scan, History
│   ├── caretaker/               # Dashboard, Patient Detail, Add Medication
│   ├── common/                  # Shared components (cards, charts, loading)
│   └── theme/                   # Material 3 colors, typography, theme
└── util/
    ├── TokenManager.kt          # EncryptedSharedPreferences
    ├── AlarmScheduler.kt        # Medication reminder alarms
    ├── NetworkUtils.kt          # Connectivity observer
    └── Constants.kt             # Shared constants
```

## Features

### Patient View
- **Dashboard:** Today's medication schedule with "Take" buttons, adherence streak, stats
- **Medication List:** Full list of active medications with details
- **Scan Prescription:** Camera/gallery image capture with AI-powered OCR extraction
- **Adherence History:** Date-range filtered logs with color-coded statuses and charts
- **Reminders:** AlarmManager-based notifications with "Mark as Taken" action

### Caretaker View
- **Dashboard:** Patient summary cards, search, add patient dialog
- **Patient Detail:** Tabbed view with medications, adherence stats, and AI predictions
- **Add Medication:** Full form with frequency dropdown, time pickers, and instructions

### Offline Support
- Room caching for medications and today's schedule
- Falls back to cached data when network is unavailable
- NetworkUtils with Flow-based connectivity observation

## Setup

1. Open the project in Android Studio (Arctic Fox or later)
2. Sync Gradle dependencies
3. Configure the API base URL in `app/build.gradle.kts` (default: `http://10.0.2.2:8000/api`)
4. Run on an emulator or device (minimum SDK 26 / Android 8.0)

## API Configuration

The base URL defaults to `http://10.0.2.2:8000/api` for the Android emulator (maps to host machine's localhost:8000). To change it, update the `BASE_URL` buildConfigField in `app/build.gradle.kts`.

## Design Principles

- Large tap targets (48dp minimum) for accessibility
- Clear, readable fonts (16sp body minimum) suitable for elderly users
- Medical teal/cyan color scheme (#0891B2)
- Color-coded statuses: green (taken), red (missed), yellow (late)
- Loading, error, and empty state handling on all screens
