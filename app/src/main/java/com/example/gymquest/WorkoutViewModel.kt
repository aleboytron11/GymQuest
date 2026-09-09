package com.example.gymquest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.Workout
import data.WorkoutCategory
import data.WorkoutDatabase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDateTime

data class WorkoutUiState(
    val workouts: List<Workout> = emptyList(),
    val totalXP: Int = 0,
    val characterLevel: Int = 1,
    val selectedCategory: WorkoutCategory? = null
)

class WorkoutViewModel(private val database: WorkoutDatabase? = null) : ViewModel() {
    private val _uiState = MutableStateFlow(WorkoutUiState())
    val uiState: StateFlow<WorkoutUiState> = _uiState.asStateFlow()

    init {
        loadWorkouts()
    }

    fun addWorkout(
        exerciseName: String,
        category: WorkoutCategory,
        reps: Int,
        sets: Int,
        weightPounds: Int? = null
    ) {
        viewModelScope.launch {
            val xpEarned = reps * sets * 5
            val workout = Workout(
                exerciseName = exerciseName,
                category = category,
                reps = reps,
                sets = sets,
                weightPounds = weightPounds,
                xpEarned = xpEarned,
                timestamp = LocalDateTime.now().toString()
            )
            
            database?.workoutDao()?.insert(workout)
            loadWorkouts()
        }
    }

    fun deleteWorkout(workout: Workout) {
        viewModelScope.launch {
            database?.workoutDao()?.delete(workout)
            loadWorkouts()
        }
    }

    fun filterByCategory(category: WorkoutCategory) {
        val currentState = _uiState.value
        _uiState.value = currentState.copy(selectedCategory = category)
    }

    fun clearFilter() {
        val currentState = _uiState.value
        _uiState.value = currentState.copy(selectedCategory = null)
    }

    private fun loadWorkouts() {
        viewModelScope.launch {
            val allWorkouts = database?.workoutDao()?.getAllWorkouts() ?: emptyList()
            val filteredWorkouts = if (_uiState.value.selectedCategory != null) {
                allWorkouts.filter { it.category == _uiState.value.selectedCategory }
            } else {
                allWorkouts
            }

            val totalXP = filteredWorkouts.sumOf { it.xpEarned }
            val characterLevel = (totalXP / 1000) + 1

            _uiState.value = WorkoutUiState(
                workouts = filteredWorkouts,
                totalXP = totalXP,
                characterLevel = characterLevel,
                selectedCategory = _uiState.value.selectedCategory
            )
        }
    }
}
