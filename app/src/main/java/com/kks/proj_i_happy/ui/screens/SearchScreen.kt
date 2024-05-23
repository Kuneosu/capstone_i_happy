package com.kks.proj_i_happy.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.kks.proj_i_happy.util.DefaultScreen

@Composable
fun SearchScreen(navController: NavController) {
    DefaultScreen(navController) {
        SearchBody()
    }
}

@Composable
fun SearchBody(){
    Text(text = "Search Screen")
}
