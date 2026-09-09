package com.example.gymquest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.gymquest.ui.theme.GymQuestTheme

class MainActivity : ComponentActivity() {
    private val workoutViewModel: WorkoutViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GymQuestTheme {
                GymQuestApp(workoutViewModel)
            }
        }
    }
}

@Composable
fun GymQuestApp(viewModel: WorkoutViewModel) {
    var selectedTab by remember { mutableIntStateOf(0) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(0xFF0a0a0a),
        bottomBar = {
            NavigationBar(
                containerColor = Color(0xFF1a1a1a),
                modifier = Modifier.background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF1a1a1a),
                            Color(0xFF0f0f0f)
                        )
                    )
                )
            ) {
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.FavoriteBorder, contentDescription = "Log") },
                    label = { Text("Log") },
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xFF00FF00),
                        selectedTextColor = Color(0xFF00FF00),
                        indicatorColor = Color(0xFF00FF00).copy(alpha = 0.15f),
                        unselectedIconColor = Color(0xFF666666),
                        unselectedTextColor = Color(0xFF666666)
                    )
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.List, contentDescription = "Browse") },
                    label = { Text("Browse") },
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xFF00FF00),
                        selectedTextColor = Color(0xFF00FF00),
                        indicatorColor = Color(0xFF00FF00).copy(alpha = 0.15f),
                        unselectedIconColor = Color(0xFF666666),
                        unselectedTextColor = Color(0xFF666666)
                    )
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Home, contentDescription = "Character") },
                    label = { Text("Character") },
                    selected = selectedTab == 2,
                    onClick = { selectedTab = 2 },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xFF00FF00),
                        selectedTextColor = Color(0xFF00FF00),
                        indicatorColor = Color(0xFF00FF00).copy(alpha = 0.15f),
                        unselectedIconColor = Color(0xFF666666),
                        unselectedTextColor = Color(0xFF666666)
                    )
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Info, contentDescription = "Library") },
                    label = { Text("Library") },
                    selected = selectedTab == 3,
                    onClick = { selectedTab = 3 },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xFF00FF00),
                        selectedTextColor = Color(0xFF00FF00),
                        indicatorColor = Color(0xFF00FF00).copy(alpha = 0.15f),
                        unselectedIconColor = Color(0xFF666666),
                        unselectedTextColor = Color(0xFF666666)
                    )
                )
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF0a0a0a),
                            Color(0xFF1a0a1a),
                            Color(0xFF0a0a0a)
                        )
                    )
                )
                .padding(paddingValues)
        ) {
            AnimatedContent(
                targetState = selectedTab,
                transitionSpec = {
                    fadeIn(animationSpec = tween(300)) togetherWith fadeOut(animationSpec = tween(300))
                },
                label = "Screen transition"
            ) { tab ->
                when (tab) {
                    0 -> LogWorkoutScreenEnhanced(viewModel, paddingValues)
                    1 -> BrowseWorkoutsScreenEnhanced(viewModel, paddingValues)
                    2 -> CharacterScreenEnhanced(viewModel, paddingValues)
                    3 -> ExerciseLibraryEnhanced(paddingValues)
                }
            }
        }
    }
}
