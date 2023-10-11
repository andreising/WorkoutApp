package com.andreisingeleytsev.workoutapp.ui.screens.diet_list_screen

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andreisingeleytsev.workoutapp.R
import com.andreisingeleytsev.workoutapp.ui.utils.DietItem
import com.andreisingeleytsev.workoutapp.ui.utils.DietItemsList
import com.andreisingeleytsev.workoutapp.ui.utils.WorkoutAppFonts

@Composable
fun DietListScreen() {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(DietItemsList.list) {
            DietListUIItem(dietItem = it)
        }
    }
}

@Composable
fun DietListUIItem(dietItem: DietItem) {
    Column(modifier = Modifier
        .padding(horizontal = 24.dp, vertical = 12.dp)
        .fillMaxWidth()) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp), shape = RoundedCornerShape(10.dp)
        ) {
            Image(
                painter = painterResource(id = dietItem.image),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(id = dietItem.name), style = TextStyle(
                color = Color.Black,
                fontSize = 16.sp,
                fontFamily = WorkoutAppFonts.font
            )
        )
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