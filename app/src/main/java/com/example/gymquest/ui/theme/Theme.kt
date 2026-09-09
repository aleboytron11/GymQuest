package com.example.gymquest.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF00FF00),
    primaryContainer = Color(0xFF003300),
    secondary = Color(0xFFFF00FF),
    secondaryContainer = Color(0xFF330033),
    tertiary = Color(0xFF00FFFF),
    tertiaryContainer = Color(0xFF003333),
    background = Color(0xFF0a0a0a),
    surface = Color(0xFF1a1a1a),
    error = Color(0xFFFF0000),
    onBackground = Color(0xFFFFFFFF),
    onSurface = Color(0xFFFFFFFF),
    onPrimary = Color(0xFF000000),
    onSecondary = Color(0xFF000000),
    onTertiary = Color(0xFF000000),
    onError = Color(0xFFFFFFFF)
)

@Composable
fun GymQuestTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = PixelTypography,
        content = content
    )
}
