package com.example.jetchat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetchat.screens.AppScreens
import com.example.jetchat.screens.ChatListScreen
import com.example.jetchat.screens.LoginScreen
import com.example.jetchat.screens.ProfileScreen
import com.example.jetchat.screens.SignUpScreen
import com.example.jetchat.screens.SingleChatScreen
import com.example.jetchat.screens.SingleStatusScreen
import com.example.jetchat.screens.StatusListScreen
import com.example.jetchat.ui.theme.JetChatTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetChatTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                        BottomNavHost()
                }
            }
        }
    }
}


@Composable
fun BottomNavHost(
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreens.LoginScreen.name,
        modifier = Modifier
    ) {
        composable(route = AppScreens.ProfileScreen.name){
            ProfileScreen()
        }
        composable(route = AppScreens.LoginScreen.name){
            LoginScreen()
        }
        composable(route = AppScreens.ChatListScreen.name){
            ChatListScreen()
        }
        composable(route = AppScreens.StatusListScreen.name){
            StatusListScreen()
        }
        composable(route = AppScreens.SignUpScreen.name){
            SignUpScreen()
        }
        composable(route = AppScreens.SingleChatScreen.name){
            SingleChatScreen()
        }
        composable(route = AppScreens.SingleStatusScreen.name){
            SingleStatusScreen()
        }


    }
}