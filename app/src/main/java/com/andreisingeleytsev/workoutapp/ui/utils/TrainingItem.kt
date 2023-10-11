package com.andreisingeleytsev.workoutapp.ui.utils

import com.andreisingeleytsev.workoutapp.R

data class TrainingItem(
    val name: Int,
    val title: Int,
    val time: String,
    val exerciseIndexesList: List<Int>,
    val image: Int,
)

object WorkoutList {
    val list = listOf(
        TrainingItem(
            name = R.string.full_body_blast,
            title = R.string.this_workout_is_designed_to_target_all_major_muscle_groups_in_your_body_including_legs_chest_back_shoulders_and_glutes_ideal_for_strengthening_and_sculpting_your_entire_body,
            time = "45",
            exerciseIndexesList = listOf(0, 3, 6, 8, 10, 14, 18),
            image = R.drawable.full_body
        ),
        TrainingItem(
            name = R.string.hiit_intensity,
            title = R.string.a_high_intensity_interval_training_hiit_session_to_help_you_burn_fat_and_improve_endurance_it_includes_short_bursts_of_intense_activity_with_brief_rest_periods,
            time = "30",
            exerciseIndexesList = listOf(1, 3, 6, 4, 0, 11, 16),
            image = R.drawable.hiit
        ),
        TrainingItem(
            name = R.string.core_crusher,
            title = R.string.focus_on_strengthening_your_core_muscles_with_this_workout_it_includes_exercises_to_target_your_abdominal_muscles_and_improve_core_stability,
            time = "20",
            exerciseIndexesList = listOf(2, 5, 6, 0, 7, 3, 12),
            image = R.drawable.core
        ),
        TrainingItem(
            name = R.string.total_body_toning,
            title = R.string.this_program_is_designed_to_tone_and_strengthen_all_major_muscle_groups_providing_a_full_body_workout_it_s_great_for_building_overall_strength_and_fitness,
            time = "60",
            exerciseIndexesList = listOf(0, 3, 6, 9, 13, 15, 17),
            R.drawable.plank
        )
    )
}






