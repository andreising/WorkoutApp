package com.andreisingeleytsev.workoutapp.ui.utils

import com.andreisingeleytsev.workoutapp.R

data class DietItem(
    val name: Int,
    val title: Int,
    val cal: Int,
    val image: Int
)

object DietItemsList {
    val list = listOf(
        DietItem(
            name = R.string.high_protein_diet,
            title = R.string.description_this_high_protein_diet_is_designed_to_help_you_increase_muscle_mass_and_recover_after_intense_workouts_it_is_rich_in_proteins_which_are_essential_for_muscle_growth_and_repair_this_diet_plan_includes_a_variety_of_protein_rich_foods_to_support_your_fitness_goals_recommendations_breakfast_scrambled_eggs_with_vegetables_300_calories_lunch_grilled_chicken_salad_400_calories_snack_greek_yogurt_150_calories_dinner_salmon_with_quinoa_450_calories_snack_protein_shake_200_calories_total_calories_1500_calories_this_diet_provides_a_balanced_combination_of_proteins_healthy_fats_and_carbohydrates_to_fuel_your_workouts_and_optimize_recovery_remember_to_stay_hydrated_and_consult_with_a_nutritionist_or_dietitian_for_personalized_adjustments,
            cal = 1500,
            image = R.drawable.diet1
        ),
        DietItem(
            name = R.string.low_carb_diet,
            title = R.string.description_this_low_carb_diet_focuses_on_reducing_carbohydrate_intake_to_help_you_shed_body_fat_it_s_suitable_for_athletes_looking_to_lose_weight_and_improve_their_body_composition_this_diet_emphasizes_whole_foods_and_limits_processed_carbohydrates_recommendations_breakfast_avocado_toast_350_calories_lunch_spinach_and_tofu_salad_300_calories_snack_almonds_200_calories_dinner_grilled_turkey_with_vegetables_400_calories_snack_cottage_cheese_150_calories_total_calories_1400_calories_by_reducing_carbs_and_increasing_protein_and_healthy_fats_this_diet_can_help_you_achieve_your_fitness_goals_make_sure_to_monitor_your_progress_and_adjust_the_diet_as_needed_with_the_guidance_of_a_healthcare_professional,
            cal = 1400,
            image = R.drawable.diet2
        ), DietItem(
            name = R.string.balanced_diet,
            title = R.string.description_this_balanced_diet_provides_a_mix_of_proteins_carbohydrates_and_fats_to_enhance_overall_physical_performance_and_endurance_it_s_suitable_for_athletes_looking_to_maintain_their_fitness_levels_while_enjoying_a_variety_of_nutritious_foods_recommendations_breakfast_oatmeal_with_berries_350_calories_lunch_brown_rice_with_chicken_400_calories_snack_mixed_nuts_200_calories_dinner_baked_salmon_with_sweet_potato_450_calories_snack_fruit_salad_150_calories_total_calories_1550_calories_the_balanced_combination_of_macronutrients_in_this_diet_helps_sustain_energy_levels_throughout_the_day_adjust_portion_sizes_and_food_choices_as_needed_based_on_your_individual_needs_and_goals,
            cal = 1550, image = R.drawable.diet3
        )
    )
}
