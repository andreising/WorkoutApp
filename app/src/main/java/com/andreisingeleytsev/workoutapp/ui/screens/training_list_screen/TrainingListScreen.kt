package com.andreisingeleytsev.workoutapp.ui.screens.training_list_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.andreisingeleytsev.workoutapp.R
import com.andreisingeleytsev.workoutapp.ui.utils.Routes
import com.andreisingeleytsev.workoutapp.ui.utils.TrainingItem
import com.andreisingeleytsev.workoutapp.ui.utils.WorkoutAppFonts
import com.andreisingeleytsev.workoutapp.ui.utils.WorkoutList

@Composable
fun TrainingListScreen(navHostController: NavHostController) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(WorkoutList.list) {
            TrainingListUIItem(trainingItem = it, navHostController)
        }
    }
}

@Composable
fun TrainingListUIItem(trainingItem: TrainingItem, navHostController: NavHostController) {
    Card(
        modifier = Modifier
            .padding(horizontal = 24.dp, vertical = 12.dp)
            .fillMaxWidth()
            .height(160.dp)
            .clickable {
                navHostController.navigate(
                    Routes.TRAINING_SCREEN + "/${
                        WorkoutList.list.indexOf(
                            trainingItem
                        )
                    }"
                )
            }
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomStart) {
            Image(
                painter = painterResource(id = trainingItem.image),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Column(Modifier.padding(20.dp)) {
                Text(
                    text = stringResource(id = trainingItem.name),
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp,
                        fontFamily = WorkoutAppFonts.font
                    )
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painterResource(id = R.drawable.icon_timer),
                        contentDescription = null,
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = trainingItem.time + stringResource(id = R.string.min),
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 14.sp,
                            fontFamily = WorkoutAppFonts.font
                        )
                    )
                }
            }

        }
    }
}