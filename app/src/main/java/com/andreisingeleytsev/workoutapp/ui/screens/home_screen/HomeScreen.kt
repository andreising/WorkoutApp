package com.andreisingeleytsev.workoutapp.ui.screens.home_screen

import android.icu.util.LocaleData
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.andreisingeleytsev.workoutapp.R
import com.andreisingeleytsev.workoutapp.ui.theme.PrimaryColor
import com.andreisingeleytsev.workoutapp.ui.utils.DietItem
import com.andreisingeleytsev.workoutapp.ui.utils.DietItemsList
import com.andreisingeleytsev.workoutapp.ui.utils.Routes
import com.andreisingeleytsev.workoutapp.ui.utils.TrainingItem
import com.andreisingeleytsev.workoutapp.ui.utils.WorkoutAppFonts
import com.andreisingeleytsev.workoutapp.ui.utils.WorkoutList
import java.time.LocalDate


@Composable
fun HomeScreen(navHostController: NavHostController) {
    val today = LocalDate.now()
    Column(modifier = Modifier.fillMaxSize()) {
        CarouselItem(isExercise = true, WorkoutList.list, navHostController = navHostController)
        CarouselItem(isExercise = false, DietItemsList.list, navHostController = navHostController)
        Card(
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 16.dp)
                .fillMaxSize(),
            shape = RoundedCornerShape(16.dp)
        ) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.CenterStart) {
                Image(
                    painter = painterResource(id = R.drawable.home_screen_card_img),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Column(Modifier.padding(24.dp)) {
                    Text(
                        text = stringResource(R.string.today_is), style = TextStyle(
                            color = Color.White,
                            fontSize = 16.sp,
                            fontFamily = WorkoutAppFonts.font
                        )
                    )
                    Text(
                        text = today.dayOfMonth.toString() + " " + today.month, style = TextStyle(
                            color = Color.White,
                            fontSize = 20.sp,
                            fontFamily = WorkoutAppFonts.font
                        )
                    )
                    Text(
                        text = today.dayOfWeek.name, style = TextStyle(
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

@Composable
fun CarouselItem(isExercise: Boolean, list: List<Any>, navHostController: NavHostController) {
    Row(
        modifier = Modifier
            .padding(horizontal = 24.dp, vertical = 16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = if (isExercise) stringResource(id = R.string.exercises)
            else stringResource(id = R.string.daily_diet), style = TextStyle(
                color = Color.Black,
                fontSize = 16.sp,
                fontFamily = WorkoutAppFonts.font
            )
        )
        Text(
            text = stringResource(R.string.see_all), style = TextStyle(
                color = PrimaryColor,
                fontSize = 14.sp,
                fontFamily = WorkoutAppFonts.font
            ), modifier = Modifier.clickable {
                navHostController.navigate(
                    if (isExercise) Routes.EXERCISE_LIST_SCREEN
                    else Routes.DIET_LIST_SCREEN
                )
            }
        )
    }
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(list) { item ->
            when (item) {
                is TrainingItem -> ExerciseUIItem(
                    trainingItem = item,
                    navHostController = navHostController
                )

                is DietItem -> DietUIItem(dietItem = item, navHostController = navHostController)
            }
        }
    }
}

@Composable
fun ExerciseUIItem(trainingItem: TrainingItem, navHostController: NavHostController) {
    Card(
        modifier = Modifier
            .padding(start = 16.dp)
            .width(210.dp)
            .height(180.dp)
            .clickable {
                navHostController.navigate(
                    Routes.TRAINING_SCREEN + "/${
                        WorkoutList.list.indexOf(
                            trainingItem
                        )
                    }"
                )
            }, shape = RoundedCornerShape(16.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomStart) {
            Image(
                painter = painterResource(id = trainingItem.image),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = stringResource(id = trainingItem.name), style = TextStyle(
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

@Composable
fun DietUIItem(dietItem: DietItem, navHostController: NavHostController) {
    Column(modifier = Modifier.padding(start = 16.dp)) {
        Card(modifier = Modifier.size(140.dp), shape = RoundedCornerShape(10.dp)) {
            Image(
                painter = painterResource(id = dietItem.image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        navHostController.navigate(
                            Routes.DIET_SCREEN + "/${
                                DietItemsList.list.indexOf(
                                    dietItem
                                )
                            }"
                        )
                    },
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(id = dietItem.name), style = TextStyle(
                color = Color.Black,
                fontSize = 14.sp,
                fontFamily = WorkoutAppFonts.font
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(painterResource(id = R.drawable.icon_flash), contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = dietItem.cal.toString() + stringResource(id = R.string.cal),
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 12.sp,
                    fontFamily = WorkoutAppFonts.font
                )
            )
        }
    }
}