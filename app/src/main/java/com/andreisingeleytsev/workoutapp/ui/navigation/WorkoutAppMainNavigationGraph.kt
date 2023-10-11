package com.andreisingeleytsev.workoutapp.ui.navigation


import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.andreisingeleytsev.workoutapp.ui.screens.diet_list_screen.DietListScreen
import com.andreisingeleytsev.workoutapp.ui.screens.diet_screen.DietScreen
import com.andreisingeleytsev.workoutapp.ui.screens.training_screen.ExerciseScreen
import com.andreisingeleytsev.workoutapp.ui.screens.training_list_screen.TrainingListScreen
import com.andreisingeleytsev.workoutapp.ui.screens.home_screen.HomeScreen
import com.andreisingeleytsev.workoutapp.ui.screens.onboard_screen.OnboardScreen
import com.andreisingeleytsev.workoutapp.ui.screens.training_screen.TrainingScreen
import com.andreisingeleytsev.workoutapp.ui.utils.DietItemsList
import com.andreisingeleytsev.workoutapp.ui.utils.ExercisesList
import com.andreisingeleytsev.workoutapp.ui.utils.Routes
import com.andreisingeleytsev.workoutapp.ui.utils.WorkoutList


@Composable
fun WorkoutAppMainNavigationGraph(
    navHostController: NavHostController, startDestination: String, onBoardFinished: () -> Unit
) {
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    NavHost(
        navController = navHostController, startDestination = startDestination,
        modifier = Modifier.background(Color.Transparent)
    ) {
        composable(Routes.ONBOARDING_SCREEN) {
            OnboardScreen(navHostController = navHostController) {
                onBoardFinished.invoke()
            }
        }
        composable(Routes.HOME_SCREEN) {
            HomeScreen(navHostController = navHostController)
        }
        composable(Routes.DIET_SCREEN+"/{index}") {
            val index = remember {
                navBackStackEntry?.arguments?.getString("index")?.toInt() ?: 0
            }
            DietScreen(dietItem = DietItemsList.list[index])
        }
        composable(Routes.DIET_LIST_SCREEN) {
            DietListScreen()
        }
        composable(Routes.EXERCISE_LIST_SCREEN) {
            TrainingListScreen(navHostController = navHostController)
        }
        composable(Routes.TRAINING_SCREEN+"/{trainingIndex}") {
            val index = remember {
                navBackStackEntry?.arguments?.getString("trainingIndex")?.toInt() ?: 0
            }
            TrainingScreen(trainingItem = WorkoutList.list[index], navHostController)
        }
    }
}
