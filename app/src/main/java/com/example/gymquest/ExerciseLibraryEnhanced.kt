package com.example.gymquest

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.WorkoutCategory

@Composable
fun ExerciseLibraryEnhanced(paddingValues: PaddingValues) {
    val exercises = remember {
        mapOf(
            WorkoutCategory.CHEST to listOf(
                "Bench Press",
                "Incline Press",
                "Dumbbell Fly",
                "Push-ups",
                "Chest Dip"
            ),
            WorkoutCategory.BACK to listOf(
                "Deadlift",
                "Barbell Row",
                "Pull-ups",
                "Lat Pulldown",
                "Bent Over Row"
            ),
            WorkoutCategory.LEGS to listOf(
                "Squat",
                "Leg Press",
                "Leg Curl",
                "Leg Extension",
                "Lunges"
            ),
            WorkoutCategory.ARMS to listOf(
                "Barbell Curl",
                "Tricep Dip",
                "Dumbbell Curl",
                "Tricep Pushdown",
                "Hammer Curl"
            ),
            WorkoutCategory.SHOULDERS to listOf(
                "Shoulder Press",
                "Lateral Raise",
                "Front Raise",
                "Shrug",
                "Machine Shoulder Press"
            ),
            WorkoutCategory.CARDIO to listOf(
                "Running",
                "Cycling",
                "Jump Rope",
                "Rowing Machine",
                "Elliptical"
            ),
            WorkoutCategory.CORE to listOf(
                "Plank",
                "Sit-ups",
                "Cable Crunch",
                "Ab Wheel",
                "Hanging Leg Raise"
            )
        )
    }

    var expandedCategory by remember { mutableStateOf<WorkoutCategory?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(16.dp)
            .background(Color(0xFF0a0a0a))
    ) {
        Text(
            text = "Exercise Library",
            color = Color(0xFF00FF00),
            style = androidx.compose.material3.MaterialTheme.typography.displaySmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(exercises.keys.toList()) { category ->
                ExerciseCategoryCard(
                    category = category,
                    exercises = exercises[category] ?: emptyList(),
                    isExpanded = expandedCategory == category,
                    onToggle = {
                        expandedCategory = if (expandedCategory == category) null else category
                    }
                )
            }
        }
    }
}

@Composable
fun ExerciseCategoryCard(
    category: WorkoutCategory,
    exercises: List<String>,
    isExpanded: Boolean,
    onToggle: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1a1a1a),
            contentColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${category.emoji} ${category.displayName}",
                    color = Color(0xFF00FF00),
                    fontSize = 16.sp
                )
                Text(
                    text = if (isExpanded) "▼" else "▶",
                    color = Color(0xFFFF00FF),
                    fontSize = 14.sp
                )
            }

            if (isExpanded) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    exercises.forEach { exercise ->
                        Text(
                            text = "• $exercise",
                            color = Color(0xFFCCCCCC),
                            fontSize = 12.sp,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                }
            }
        }
    }
}
