package com.andreisingeleytsev.workoutapp.ui.screens.training_screen

sealed class TrainingEvents{
    data object OnMainTrainButtonPressed: TrainingEvents()
    data object OnMainExerciseButtonPressed: TrainingEvents()
    data class OnExercisePressed(val index: Int) : TrainingEvents()
}
