package com.example.gymquest

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.WorkoutCategory

@Composable
fun LogWorkoutScreenEnhanced(
    viewModel: WorkoutViewModel,
    paddingValues: PaddingValues
) {
    var exerciseName by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf(WorkoutCategory.CHEST) }
    var reps by remember { mutableStateOf("") }
    var sets by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var successMessage by remember { mutableStateOf("") }
    var showSuccess by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(16.dp)
            .background(Color.Transparent)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Log Workout",
            color = Color(0xFF00FF00),
            style = androidx.compose.material3.MaterialTheme.typography.displaySmall,
            modifier = Modifier.padding(top = 16.dp)
        )

        Text(
            text = "💪 Track your gains in real-time",
            color = Color(0xFFFF00FF),
            fontSize = 12.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = exerciseName,
            onValueChange = { exerciseName = it },
            label = { Text("Exercise Name", color = Color(0xFF999999)) },
            modifier = Modifier.fillMaxWidth(),
            textStyle = androidx.compose.material3.LocalTextStyle.current.copy(color = Color.White),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF00FF00),
                unfocusedBorderColor = Color(0xFF333333),
                cursorColor = Color(0xFF00FF00),
                focusedLabelColor = Color(0xFF00FF00),
                unfocusedLabelColor = Color(0xFF666666)
            )
        )

        Box {
            Button(
                onClick = { expanded = true },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1a1a1a),
                    contentColor = Color(0xFF00FF00)
                ),
                shape = androidx.compose.material3.RoundedCornerShape(4.dp)
            ) {
                Text("${selectedCategory.emoji} ${selectedCategory.displayName}")
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.background(Color(0xFF1a1a1a))
            ) {
                WorkoutCategory.entries.forEach { category ->
                    DropdownMenuItem(
                        text = { Text("${category.emoji} ${category.displayName}", color = Color.White) },
                        onClick = {
                            selectedCategory = category
                            expanded = false
                        }
                    )
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                value = reps,
                onValueChange = { reps = it },
                label = { Text("Reps", color = Color(0xFF999999)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f),
                textStyle = androidx.compose.material3.LocalTextStyle.current.copy(color = Color.White),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF00FF00),
                    unfocusedBorderColor = Color(0xFF333333),
                    cursorColor = Color(0xFF00FF00),
                    focusedLabelColor = Color(0xFF00FF00),
                    unfocusedLabelColor = Color(0xFF666666)
                )
            )
            OutlinedTextField(
                value = sets,
                onValueChange = { sets = it },
                label = { Text("Sets", color = Color(0xFF999999)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f),
                textStyle = androidx.compose.material3.LocalTextStyle.current.copy(color = Color.White),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF00FF00),
                    unfocusedBorderColor = Color(0xFF333333),
                    cursorColor = Color(0xFF00FF00),
                    focusedLabelColor = Color(0xFF00FF00),
                    unfocusedLabelColor = Color(0xFF666666)
                )
            )
        }

        OutlinedTextField(
            value = weight,
            onValueChange = { weight = it },
            label = { Text("Weight (lbs) - Optional", color = Color(0xFF999999)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth(),
            textStyle = androidx.compose.material3.LocalTextStyle.current.copy(color = Color.White),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF00FF00),
                unfocusedBorderColor = Color(0xFF333333),
                cursorColor = Color(0xFF00FF00),
                focusedLabelColor = Color(0xFF00FF00),
                unfocusedLabelColor = Color(0xFF666666)
            )
        )

        Button(
            onClick = {
                if (exerciseName.isNotBlank() && reps.isNotBlank() && sets.isNotBlank()) {
                    val xpGained = reps.toIntOrNull()?.let { r -> sets.toIntOrNull()?.let { s -> r * s * 5 } } ?: 0
                    viewModel.addWorkout(
                        exerciseName = exerciseName,
                        category = selectedCategory,
                        reps = reps.toIntOrNull() ?: 0,
                        sets = sets.toIntOrNull() ?: 0,
                        weightPounds = weight.toIntOrNull()
                    )
                    successMessage = "✅ WORKOUT LOGGED!\n+$xpGained XP Earned!"
                    showSuccess = true
                    exerciseName = ""
                    reps = ""
                    sets = ""
                    weight = ""
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF00FF00),
                contentColor = Color.Black
            ),
            shape = androidx.compose.material3.RoundedCornerShape(8.dp)
        ) {
            Icon(Icons.Filled.Check, contentDescription = "Log")
            Text("Log Workout", modifier = Modifier.padding(start = 8.dp), fontSize = 14.sp)
        }

        if (showSuccess) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color(0xFF003300),
                                Color(0xFF001a1a)
                            )
                        )
                    )
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = successMessage,
                        color = Color(0xFF00FF00),
                        style = androidx.compose.material3.MaterialTheme.typography.bodyLarge
                    )
                    Button(
                        onClick = { showSuccess = false },
                        modifier = Modifier.padding(top = 8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF00FF00),
                            contentColor = Color.Black
                        )
                    ) {
                        Text("Continue", fontSize = 12.sp)
                    }
                }
            }
        }
    }
}
