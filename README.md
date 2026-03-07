# MedAssist Mobile App

Kotlin Android app with Jetpack Compose.

## Architecture

```mermaid
graph TD
    subgraph UI
        Screens[Compose Screens]
        ViewModels[ViewModels]
    end
    
    subgraph Data
        Repos[Repositories]
        API[Retrofit]
        Room[Room DB]
        Cache[EncryptedSharedPrefs]
    end
    
    Screens --> ViewModels
    ViewModels --> Repos
    Repos --> API
    Repos --> Room
    Repos --> Cache
```

## Navigation

```mermaid
graph LR
    Login --> PD[Patient Dashboard]
    Login --> CD[Caretaker Dashboard]
    
    PD --> PM[Medications]
    PD --> PS[Scan]
    PD --> PH[History]
    
    CD --> PP[Patient Detail]
    PP --> PAM[Add Medication]
```

## Tech Stack

- Kotlin
- Jetpack Compose
- Material 3
- MVVM + Hilt
- Retrofit + OkHttp
- Room
- Navigation Compose

## Setup

1. Open in Android Studio
2. Update BASE_URL in build.gradle.kts
3. Run on device/emulator
