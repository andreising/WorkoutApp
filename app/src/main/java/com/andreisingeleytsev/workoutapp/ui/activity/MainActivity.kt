package com.andreisingeleytsev.workoutapp.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.andreisingeleytsev.workoutapp.R
import com.andreisingeleytsev.workoutapp.ui.navigation.WorkoutAppMainNavigationGraph
import com.andreisingeleytsev.workoutapp.ui.utils.Routes
import com.andreisingeleytsev.workoutapp.ui.utils.WorkoutAppFonts
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var viewModel: MainViewModel

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navHostController = rememberNavController()
            val navBackStackEntry by navHostController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            if (!viewModel.isLoading.value) {
                Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
                    if (currentRoute != Routes.ONBOARDING_SCREEN) CenterAlignedTopAppBar(
                        title = {
                            Text(
                                text = stringResource(
                                    id = when (currentRoute) {
                                        Routes.HOME_SCREEN -> {
                                            R.string.home
                                        }

                                        Routes.TRAINING_SCREEN + "/{trainingIndex}" -> {
                                            R.string.exercises
                                        }

                                        Routes.DIET_LIST_SCREEN -> {
                                            R.string.daily_diet
                                        }

                                        Routes.EXERCISE_LIST_SCREEN -> {
                                            R.string.exercises
                                        }

                                        Routes.DIET_SCREEN + "/{index}" -> {
                                            R.string.diet
                                        }

                                        else -> {
                                            R.string.diet
                                        }
                                    }
                                ), style = TextStyle(
                                    color = Color.Black,
                                    fontSize = 16.sp,
                                    fontFamily = WorkoutAppFonts.font,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        }, navigationIcon = {
                            if (currentRoute != Routes.HOME_SCREEN) IconButton(onClick = { navHostController.popBackStack() }) {
                                Icon(
                                    imageVector = Icons.Default.ArrowBack,
                                    contentDescription = null,
                                    tint = Color.Black
                                )
                            }
                        })
                }) {
                    Box(
                        modifier = Modifier
                            .padding(it)
                            .fillMaxSize()
                    ) {
                        WorkoutAppMainNavigationGraph(
                            navHostController = navHostController,
                            startDestination = viewModel.startDestination.value!!
                        ) {
                            viewModel.onBoardFinished()
                        }
                    }
                }
            }
        }
    }
}
