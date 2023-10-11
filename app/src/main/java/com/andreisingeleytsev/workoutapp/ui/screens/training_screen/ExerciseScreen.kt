package com.andreisingeleytsev.workoutapp.ui.screens.training_screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.andreisingeleytsev.workoutapp.R
import com.andreisingeleytsev.workoutapp.ui.theme.PrimaryColor
import com.andreisingeleytsev.workoutapp.ui.utils.ExerciseItem
import com.andreisingeleytsev.workoutapp.ui.utils.WorkoutAppFonts

@Composable
fun ExerciseScreen(exerciseItem: ExerciseItem, viewModel: TrainingViewModel = hiltViewModel()) {
    BackHandler {
        viewModel.isExercise.value = false
    }
    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Card(shape = RoundedCornerShape(10.dp)) {
                Image(
                    painter = painterResource(id = exerciseItem.image),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_watch),
                    contentDescription = null
                )
                Text(
                    text = viewModel.currentTime.longValue.toString() + stringResource(id = R.string.second),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
            Text(
                text = stringResource(id = exerciseItem.name),
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontFamily = WorkoutAppFonts.font
                )
            )
            Text(
                text = stringResource(id = exerciseItem.title),
                style = TextStyle(
                    color = Color.Gray,
                    fontSize = 14.sp,
                    fontFamily = WorkoutAppFonts.font
                )
            )
        }
        Button(
            onClick = {
                viewModel.onEvent(TrainingEvents.OnMainExerciseButtonPressed)
            }, colors = ButtonDefaults.buttonColors(
                containerColor = PrimaryColor
            ), modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = stringResource(R.string.stop),
                style = TextStyle(
                    color = Color.White,
                    fontSize = 16.sp,
                    fontFamily = WorkoutAppFonts.font
                )
            )
        }
    }
}