package com.andreisingeleytsev.workoutapp.ui.screens.training_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.andreisingeleytsev.workoutapp.R
import com.andreisingeleytsev.workoutapp.ui.theme.PrimaryColor
import com.andreisingeleytsev.workoutapp.ui.utils.ExerciseItem
import com.andreisingeleytsev.workoutapp.ui.utils.ExercisesList
import com.andreisingeleytsev.workoutapp.ui.utils.Routes
import com.andreisingeleytsev.workoutapp.ui.utils.TrainingItem
import com.andreisingeleytsev.workoutapp.ui.utils.UIEvents
import com.andreisingeleytsev.workoutapp.ui.utils.WorkoutAppFonts
import javax.inject.Inject

@Composable
fun TrainingScreen(
    trainingItem: TrainingItem,
    navHostController: NavHostController,
    viewModel: TrainingViewModel = hiltViewModel()
) {
    viewModel.trainingItem.value = trainingItem
    LaunchedEffect(key1 = true){
        viewModel.uiEvent.collect{
            when(it) {
                is UIEvents.OnBack -> {
                    navHostController.popBackStack()
                }

                else -> {}
            }
        }
    }
    if (viewModel.isExercise.value) ExerciseScreen(exerciseItem = ExercisesList.exercises[viewModel.currentExcerise.value!!])
    else Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Card(shape = RoundedCornerShape(10.dp)) {
            Image(
                painter = painterResource(id = trainingItem.image),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(id = trainingItem.name),
            style = TextStyle(
                color = Color.Black,
                fontSize = 20.sp,
                fontFamily = WorkoutAppFonts.font
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(id = trainingItem.title),
            style = TextStyle(
                color = Color.Gray,
                fontSize = 14.sp,
                fontFamily = WorkoutAppFonts.font
            )
        )
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.LightGray
            ), modifier = Modifier.padding(vertical = 10.dp)
        ) {
            Text(
                text = trainingItem.time + stringResource(id = R.string.min),
                style = TextStyle(
                    color = Color.White,
                    fontSize = 14.sp,
                    fontFamily = WorkoutAppFonts.font
                ), modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
            )
        }
        Button(
            onClick = {
                viewModel.onEvent(TrainingEvents.OnMainTrainButtonPressed)
            }, colors = ButtonDefaults.buttonColors(
                containerColor = PrimaryColor
            ), modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = when (viewModel.trainingState.value) {
                    0 -> {
                        stringResource(R.string.start_now)
                    }

                    1 -> {
                        stringResource(R.string.continue_)
                    }

                    2 -> {
                        stringResource(R.string.end_training)
                    }

                    else -> {
                        stringResource(R.string.end_training)
                    }
                },
                style = TextStyle(
                    color = Color.White,
                    fontSize = 16.sp,
                    fontFamily = WorkoutAppFonts.font
                )
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Column(modifier = Modifier.wrapContentSize()) {
            trainingItem.exerciseIndexesList.forEach { index ->
                ExerciseUIItem(
                    exerciseItem = ExercisesList.exercises[index]
                )
            }
        }
    }
}

@Composable
fun ExerciseUIItem(
    exerciseItem: ExerciseItem,
    viewModel: TrainingViewModel = hiltViewModel()
) {
    Row(
        modifier = Modifier
            .padding(vertical = 10.dp)
            .fillMaxWidth()
            .background(
                if (viewModel.doneExercise.contains(
                        ExercisesList.exercises.indexOf(
                            exerciseItem
                        )
                    )
                ) PrimaryColor.copy(alpha = 0.4F)
                else Color.Transparent
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Card(modifier = Modifier.size(80.dp)) {
                Image(
                    painter = painterResource(id = exerciseItem.image),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.width(24.dp))
            Column {
                Text(
                    text = stringResource(id = exerciseItem.name),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontFamily = WorkoutAppFonts.font
                    )
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painterResource(id = R.drawable.icon_timer),
                        contentDescription = null,
                        tint = Color.Gray,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = exerciseItem.time.toString() + stringResource(id = R.string.second),
                        style = TextStyle(
                            color = Color.Gray,
                            fontSize = 14.sp,
                            fontFamily = WorkoutAppFonts.font
                        )
                    )
                }
            }
        }
        IconButton(onClick = {
            viewModel.onEvent(
                TrainingEvents.OnExercisePressed(
                    ExercisesList.exercises.indexOf(
                        exerciseItem
                    )
                )
            )
        }, modifier = Modifier.size(24.dp)) {
            Image(
                painter = painterResource(id = R.drawable.btn_play),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
        }
    }
}