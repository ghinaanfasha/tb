package com.example.tb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tb.pages.LandingPage
import com.example.tb.pages.LoginPage
import com.example.tb.pages.MainScreen
import com.example.tb.pages.RegisterPage
import com.example.tb.ui.theme.Routes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = Routes.Landing
            ) {
                composable(Routes.Landing) {
                    LandingPage(navController)
                }
                composable(Routes.Register) {
                    RegisterPage(navController)
                }
                composable(Routes.Login) {
                    LoginPage(navController)
                }
                composable(Routes.Main) {
                    MainScreen(navController)
                }
            }
        }
    }
}
