package com.kks.proj_i_happy.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.kks.proj_i_happy.R
import com.kks.proj_i_happy.util.DefaultTextField
import com.kks.proj_i_happy.util.HorizonWideButton

@Composable
fun LoginScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.size(20.dp))
        Text(
            text = "환영합니다 !",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.size(20.dp))

        LoginLogo()

        Spacer(modifier = Modifier.size(20.dp))

        LoginInputArea(navController)

    }
}

@Composable
fun LoginInputArea(navController: NavController) {
    Column {
        Spacer(modifier = Modifier.size(20.dp))
        DefaultTextField(category = "아이디")
        Spacer(modifier = Modifier.size(20.dp))
        DefaultTextField(category = "비밀번호")
        Spacer(modifier = Modifier.size(40.dp))

        HorizonWideButton(
            colors = listOf(Color.Red, Color.White),
            text = "시작하기",
            border = false,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            navController.navigate("home_screen")
        }
        
        Spacer(modifier = Modifier.size(20.dp))

        HorizonWideButton(
            colors = listOf(Color.White, Color.Red),
            text = "회원가입",
            border = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            navController.navigate("signup_screen")
        }


    }
}

@Composable
fun LoginLogo() {

    Card(
        modifier = Modifier.size(300.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray
        ),
        shape = RoundedCornerShape(100.dp)
    ) {
        Image(
            painter =
            painterResource(id = R.drawable.applogo),
            contentDescription = "logo",
            modifier = Modifier
                .fillMaxSize()
                .padding(50.dp)
                .clip(RoundedCornerShape(30.dp))
        )
    }


}

@Composable
@Preview
fun PreviewLogin() {
//    LoginScreen()
}
