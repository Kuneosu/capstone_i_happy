package com.kks.proj_i_happy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kks.proj_i_happy.ui.screens.HomeScreen
import com.kks.proj_i_happy.ui.screens.LoginScreen
import com.kks.proj_i_happy.ui.screens.SignupScreen
import com.kks.proj_i_happy.ui.screens.WelcomeScreen
import com.kks.proj_i_happy.ui.theme.Proj_i_happyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Proj_i_happyTheme {
                MainNavHost()
            }
        }
    }
}

@Composable
fun MainNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "welcome_screen",
    ) {
        composable(route = "welcome_screen") {
            WelcomeScreen(navController)
        }
        composable(route = "login_screen") {
            LoginScreen(navController)
        }
        composable(route = "signup_screen") {
            SignupScreen(navController)
        }
        composable(route = "home_screen") {
            HomeScreen()
        }
    }
}