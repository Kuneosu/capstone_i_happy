package com.kks.proj_i_happy.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.kks.proj_i_happy.R
import com.kks.proj_i_happy.util.HorizonWideButton


@Composable
fun WelcomeScreen(navController: NavController) {

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(id = R.drawable.applogo),
            contentDescription = "Welcome Image",
            modifier = Modifier
                .size((LocalConfiguration.current.screenWidthDp / 1.3).dp)
                .clip(shape = RoundedCornerShape(10.dp)),
        )

        Spacer(modifier = Modifier.size(60.dp))

        AppLogoText()

        SubText()

        Spacer(modifier = Modifier.size(60.dp))

        HorizonWideButton(
            colors = listOf(Color.Red, Color.White),
            text = "로그인",
            border = false
        ) {
            navController.navigate("login_screen")
        }

        Spacer(modifier = Modifier.size(10.dp))

        HorizonWideButton(
            colors = listOf(Color.White, Color.Red),
            text = "회원가입",
            border = true
        ) {

        }
    }
}

@Composable
fun AppLogoText() {
    Text(
        text = "아이해피",
        fontSize = 48.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun SubText() {
    Text(
        text = "Get expert tips on infant & child care",
        fontSize = 20.sp,
        color = Color.Gray
    )
}




@Composable
@Preview
fun PreviewWelcome() {
//    WelcomeScreen()
}