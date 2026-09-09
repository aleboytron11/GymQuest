package com.example.gymquest

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CharacterScreenEnhanced(
    viewModel: WorkoutViewModel,
    paddingValues: PaddingValues
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(16.dp)
            .background(Color(0xFF0a0a0a)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            text = "Character",
            color = Color(0xFF00FF00),
            style = androidx.compose.material3.MaterialTheme.typography.displaySmall,
            modifier = Modifier.padding(top = 16.dp)
        )

        // Character Display
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "🧙‍♂️",
                fontSize = 120.sp,
                textAlign = TextAlign.Center
            )
        }

        // Level Display
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Level ${uiState.characterLevel}",
                color = Color(0xFF00FF00),
                fontSize = 32.sp,
                style = androidx.compose.material3.MaterialTheme.typography.displayMedium
            )

            Text(
                text = "Fitness Warrior",
                color = Color(0xFFFF00FF),
                fontSize = 16.sp
            )
        }

        // XP Progress
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "XP Progress",
                color = Color.White,
                fontSize = 14.sp
            )

            val xpInCurrentLevel = uiState.totalXP % 1000
            val xpToNextLevel = 1000

            LinearProgressIndicator(
                progress = { xpInCurrentLevel.toFloat() / xpToNextLevel },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                color = Color(0xFF00FF00),
                trackColor = Color(0xFF333333)
            )

            Text(
                text = "$xpInCurrentLevel / $xpToNextLevel XP",
                color = Color(0xFFCCCCCC),
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }

        // Stats
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(Color(0xFF1a1a1a))
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            StatRow("Total XP", "${uiState.totalXP}")
            StatRow("Workouts Logged", "${uiState.workouts.size}")
            StatRow("Total Reps", "${uiState.workouts.sumOf { it.reps * it.sets }}")
        }
    }
}

@Composable
fun StatRow(label: String, value: String) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = label,
            color = Color(0xFF999999),
            fontSize = 12.sp
        )
        Text(
            text = value,
            color = Color(0xFF00FF00),
            fontSize = 16.sp
        )
    }
}
