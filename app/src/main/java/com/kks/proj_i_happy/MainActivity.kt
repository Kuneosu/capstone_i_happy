package com.kks.proj_i_happy

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kks.proj_i_happy.ui.screens.ChatScreen
import com.kks.proj_i_happy.ui.screens.HomeScreen
import com.kks.proj_i_happy.ui.screens.LoginScreen
import com.kks.proj_i_happy.ui.screens.NewsScreen
import com.kks.proj_i_happy.ui.screens.SearchScreen
import com.kks.proj_i_happy.ui.screens.SettingScreen
import com.kks.proj_i_happy.ui.screens.SignupScreen
import com.kks.proj_i_happy.ui.screens.WelcomeScreen
import com.kks.proj_i_happy.ui.theme.Proj_i_happyTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Proj_i_happyTheme {
                MainNavHost()
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
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
            HomeScreen(navController)
        }
        composable(route = "chat_screen") {
            ChatScreen(navController)
        }
        composable(route = "news_screen") {
            NewsScreen(navController)
        }
        composable(route = "search_screen") {
            SearchScreen(navController)
        }
        composable(route = "setting_screen") {
            SettingScreen(navController)
        }
    }
}