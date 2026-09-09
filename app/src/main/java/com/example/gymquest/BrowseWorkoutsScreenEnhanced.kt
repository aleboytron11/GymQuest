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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.Workout
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun BrowseWorkoutsScreenEnhanced(
    viewModel: WorkoutViewModel,
    paddingValues: PaddingValues
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(16.dp)
            .background(Color(0xFF0a0a0a))
    ) {
        Text(
            text = "Workout History",
            color = Color(0xFF00FF00),
            style = androidx.compose.material3.MaterialTheme.typography.displaySmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            data.WorkoutCategory.entries.forEach { category ->
                Button(
                    onClick = { viewModel.filterByCategory(category) },
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp),
                ) {
                    Text(category.emoji, fontSize = 12.sp)
                }
            }
            if (uiState.selectedCategory != null) {
                Button(
                    onClick = { viewModel.clearFilter() },
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp)
                ) {
                    Text("Clear", fontSize = 10.sp)
                }
            }
        }

        if (uiState.workouts.isEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "No workouts logged yet",
                    color = Color(0xFF666666),
                    style = androidx.compose.material3.MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "Start by logging your first workout!",
                    color = Color(0xFF666666),
                    style = androidx.compose.material3.MaterialTheme.typography.bodyMedium
                )
            }
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(uiState.workouts) { workout ->
                    WorkoutCard(workout, viewModel)
                }
            }
        }
    }
}

@Composable
fun WorkoutCard(workout: Workout, viewModel: WorkoutViewModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1a1a1a),
            contentColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "${workout.category.emoji} ${workout.exerciseName}",
                    color = Color(0xFF00FF00),
                    fontSize = 14.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "${workout.reps} reps × ${workout.sets} sets${workout.weightPounds?.let { " @ ${it}lbs" } ?: ""}",
                    color = Color(0xFFCCCCCC),
                    fontSize = 12.sp
                )
                Text(
                    text = "+${workout.xpEarned} XP",
                    color = Color(0xFFFFFF00),
                    fontSize = 11.sp
                )
                Text(
                    text = formatTimestamp(workout.timestamp),
                    color = Color(0xFF666666),
                    fontSize = 10.sp
                )
            }
            IconButton(
                onClick = { viewModel.deleteWorkout(workout) }
            ) {
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = "Delete",
                    tint = Color(0xFFFF0000)
                )
            }
        }
    }
}

private fun formatTimestamp(timestamp: String): String {
    return try {
        val dateTime = LocalDateTime.parse(timestamp)
        dateTime.format(DateTimeFormatter.ofPattern("MMM d, yyyy h:mm a"))
    } catch (e: Exception) {
        timestamp
    }
}
