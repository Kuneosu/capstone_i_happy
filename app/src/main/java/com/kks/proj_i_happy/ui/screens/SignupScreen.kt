package com.kks.proj_i_happy.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.kks.proj_i_happy.util.DefaultTextField
import com.kks.proj_i_happy.util.HorizonWideButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreen(navController: NavController) {
    Scaffold(
        topBar = {
            SignupTopBar(navController)
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .background(Color.White)
        ) {
            Divider(modifier = Modifier.shadow(8.dp))

            Spacer(modifier = Modifier.padding(20.dp))

            SignupText()

            Spacer(modifier = Modifier.padding(20.dp))

            InformationCard()
        }
    }
}

@Composable
private fun InformationCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .background(Color.White)
            .shadow(8.dp)

    ) {
        Column(
            modifier = Modifier.background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.size(30.dp))
            DefaultTextField("이름")
            Spacer(modifier = Modifier.size(20.dp))
            DefaultTextField("이메일")
            Spacer(modifier = Modifier.size(20.dp))
            DefaultTextField("비밀번호")
            Spacer(modifier = Modifier.size(20.dp))
            DefaultTextField("비밀번호 확인")
            Spacer(modifier = Modifier.size(20.dp))
            SignupAgreeCheckbox()
            HorizonWideButton(
                colors = listOf(Color.Red, Color.White),
                text = "회원가입",
                border = false,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {}
            Spacer(modifier = Modifier.size(20.dp))
        }
    }
}



@Composable
private fun SignupAgreeCheckbox() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = false,
            onCheckedChange = { /*TODO*/ },
            modifier = Modifier.padding(10.dp)
        )
        Text(
            text = "이용약관에 동의합니다.",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(10.dp)
        )
    }
}

@Composable
private fun SignupText() {
    Text(
        text = "정보를 입력해주세요.",
        fontSize = 26.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun SignupTopBar(navController: NavController) {
    TopAppBar(
        title = {
            Text(
                text = "회원가입",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp),
            )
        },
        navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "ArrowBack"
                )
            }
        },
    )
}

@Composable
@Preview
fun PreviewSignup() {
//    SignupScreen()
}