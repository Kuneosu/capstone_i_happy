package com.kks.proj_i_happy.util

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kks.proj_i_happy.R

@Composable
fun DefaultScreen(navController: NavController, body: @Composable () -> Unit) {
    Scaffold(
        bottomBar = {
            CustomBottomAppBar(navController)
        }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            body()
        }
    }
}

@Composable
fun CustomBottomAppBar(navController: NavController) {
    val context = LocalContext.current
    BottomAppBar(
        containerColor = Color.White,
        modifier = Modifier.border(1.dp, Color.LightGray)
    ) {
        BottomAppBarIcon(imageId = R.drawable.tips, description = "news") {
            navController.navigate("news_screen")
        }
        BottomAppBarIcon(imageId = R.drawable.chat) {
            navController.navigate("chat_screen")
        }
        BottomAppBarIcon(imageId = R.drawable.home) {
            navController.navigate("home_screen")
        }
        BottomAppBarIcon(imageId = R.drawable.search) {
            navController.navigate("search_screen")
        }
        BottomAppBarIcon(imageId = R.drawable.setting) {
            navController.navigate("setting_screen")
        }
    }
}

@Composable
fun BottomAppBarIcon(imageId: Int, description: String? = null, clickEvent: () -> Unit) {
    Image(
        painter = painterResource(id = imageId),
        contentDescription = description,
        modifier = Modifier
            .fillMaxHeight()
            .padding(18.dp)
            .clickable { clickEvent() }
    )
}