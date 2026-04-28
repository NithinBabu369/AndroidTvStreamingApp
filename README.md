

# Android TV Streaming App

A basic Android TV-compatible app that displays a list of video content and allows for full-screen playback.

## Features
- **Home Screen**: TV-style layout with categories using `TvLazyColumn` and `TvLazyRow`.
- **Navigation**: Full D-pad/Remote control support for navigation and selection.
- **Playback**: Full-screen video playback using ExoPlayer (Media3).
- **Universal**: Works on both Android TV and Android Phone.
- **Auto-Focus Scaling**: Items scale and highlight when focused (Material 3 for TV).

## Requirements
- Android SDK 21+
- Android Studio Ladybug or newer
- Internet connection (to stream sample videos)

## Build & Run Instructions
1. Open the project in Android Studio.
2. Sync Gradle to download dependencies (Media3, Coil, Navigation).
3. Connect an Android TV (or emulator) or an Android Phone.
4. Click **Run** and select your device.

## Performance & Optimization
- **ExoPlayer (Media3)**: Used for efficient video streaming and buffering.
- **Coil**: Used for asynchronous image loading with memory and disk caching.
- **Resource Management**: `ExoPlayer` is released properly in `DisposableEffect` to prevent memory leaks.
- **TV Material 3**: Optimized components for focus management and performance on low-end hardware.

## Compatibility
- Tested on Android TV (Leanback) and Android Phone.
- Uses `androidx.tv` libraries for native TV experience and `androidx.compose` for standard compatibility.
