package com.kks.proj_i_happy.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.kks.proj_i_happy.util.DefaultScreen

@Composable
fun CalendarScreen(navController: NavController) {
    DefaultScreen(navController) {
        CalendarBody()
    }
}

@Composable
fun CalendarBody(){
    Text(text = "Calendar Screen")
}