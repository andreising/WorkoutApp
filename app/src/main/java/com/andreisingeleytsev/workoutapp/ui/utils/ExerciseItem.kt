package com.andreisingeleytsev.workoutapp.ui.utils

import com.andreisingeleytsev.workoutapp.R

data class ExerciseItem(
    val name: Int,
    val title: Int,
    val time: Long,
    val image: Int
)

object ExercisesList {
    val exercises = listOf(
        ExerciseItem(
            R.string.push_up,
            R.string.perform_a_push_up_with_proper_form, 30L, R.drawable.push_up
        ), // 30 секунд
        ExerciseItem(
            R.string.squats,
            R.string.perform_squats_with_feet_shoulder_width_apart, 45L, R.drawable.squats
        ), // 45 секунд
        ExerciseItem(
            R.string.plank,
            R.string.hold_a_plank_position_with_a_straight_back, 60L, R.drawable.plank
        ), // 1 минута
        ExerciseItem(
            R.string.jumping_jacks,
            R.string.do_jumping_jacks_with_arms_and_legs_spreading_out_and_in,
            45L,
            R.drawable.jumping_jacks
        ), // 45 секунд
        ExerciseItem(
            R.string.mountain_climbers,
            R.string.do_mountain_climbers_by_bringing_knees_to_chest_alternately,
            30L,
            R.drawable.mountain_climb
        ), // 30 секунд
        ExerciseItem(
            R.string.burpees,
            R.string.perform_burpees_by_combining_squat_push_up_and_jump, 45L, R.drawable.burpees
        ), // 45 секунд
        ExerciseItem(
            R.string.high_knees,
            R.string.run_in_place_while_bringing_knees_up_towards_the_chest,
            30L,
            R.drawable.high_knees
        ), // 30 секунд
        ExerciseItem(
            R.string.lunges,
            R.string.do_lunges_by_stepping_forward_and_bending_both_knees, 45L, R.drawable.lunges
        ), // 45 секунд
        ExerciseItem(
            R.string.russian_twists,
            R.string.sit_down_lean_back_and_twist_torso_to_touch_the_ground_on_each_side,
            30L,
            R.drawable.rus_twist
        ), // 30 секунд
        ExerciseItem(
            R.string.bicycle_crunches,
            R.string.lie_on_your_back_and_pedal_legs_in_a_bicycle_motion_while_crunching,
            30L,
            R.drawable.crunches
        ), // 30 секунд
        ExerciseItem(
            R.string.wall_sit,
            R.string.sit_against_a_wall_with_thighs_parallel_to_the_ground, 60L, R.drawable.wall_sit
        ), // 1 минута
        ExerciseItem(
            R.string.push_up_and_rotation,
            R.string.perform_a_push_up_and_rotate_to_raise_one_arm_towards_the_ceiling,
            45L,
            R.drawable.pu_rotat
        ), // 45 секунд
        ExerciseItem(
            R.string.tricep_dips,
            R.string.use_a_chair_to_perform_tricep_dips_lowering_and_raising_your_body,
            30L,
            R.drawable.tric_dip
        ), // 30 секунд
        ExerciseItem(
            R.string.plank_with_leg_lift,
            R.string.hold_a_plank_position_and_lift_one_leg_at_a_time,
            45L,
            R.drawable.plank_with_leg
        ), // 45 секунд
        ExerciseItem(
            R.string.side_plank_left,
            R.string.balance_on_your_left_forearm_and_side_keeping_your_body_straight,
            30L,
            R.drawable.side_plank
        ), // 30 секунд
        ExerciseItem(
            R.string.side_plank_right,
            R.string.balance_on_your_right_forearm_and_side_keeping_your_body_straight,
            30L,
            R.drawable.side_plank
        ), // 30 секунд
        ExerciseItem(
            R.string.jump_squats,
            R.string.do_squats_and_add_a_jump_at_the_end_of_each_squat, 45L, R.drawable.jump_squats
        ), // 45 секунд
        ExerciseItem(
            R.string.flutter_kicks,
            R.string.lie_on_your_back_and_flutter_your_legs_up_and_down, 30L, R.drawable.flut_kicks
        ), // 30 секунд
        ExerciseItem(
            R.string.superman,
            R.string.lie_on_your_stomach_and_lift_arms_and_legs_off_the_ground,
            45L,
            R.drawable.superman
        ), // 45 секунд
        ExerciseItem(
            R.string.box_jumps,
            R.string.jump_onto_a_box_or_platform_and_step_back_down, 45L, R.drawable.box
        ) // 45 секунд
    )
}