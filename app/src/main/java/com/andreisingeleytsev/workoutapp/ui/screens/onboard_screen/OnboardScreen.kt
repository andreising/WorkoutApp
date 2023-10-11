package com.andreisingeleytsev.workoutapp.ui.screens.onboard_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.andreisingeleytsev.workoutapp.R
import com.andreisingeleytsev.workoutapp.ui.theme.PrimaryColor
import com.andreisingeleytsev.workoutapp.ui.utils.Routes
import com.andreisingeleytsev.workoutapp.ui.utils.WorkoutAppFonts


@Composable
fun OnboardScreen(navHostController: NavHostController, onClick: () -> Unit) {
    Column(modifier = Modifier
        .padding(24.dp)
        .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.onboard_img),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Text(
            text = stringResource(R.string.onboard_title), style = TextStyle(
                color = Color.Gray,
                fontSize = 14.sp,
                fontFamily = WorkoutAppFonts.font,
                textAlign = TextAlign.Center
            ), modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                navHostController.popBackStack()
                navHostController.navigate(Routes.HOME_SCREEN)
                onClick.invoke()
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = PrimaryColor
            )
        ) {
            Text(
                text = stringResource(R.string.get_started), style = TextStyle(
                    color = Color.White,
                    fontSize = 16.sp,
                    fontFamily = WorkoutAppFonts.font
                )
            )
        }
    }
}