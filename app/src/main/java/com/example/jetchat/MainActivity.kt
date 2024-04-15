package com.example.jetchat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetchat.screens.AppScreens
import com.example.jetchat.screens.ChatListScreen
import com.example.jetchat.screens.auth.LoginScreen
import com.example.jetchat.screens.ProfileScreen
import com.example.jetchat.screens.auth.SignUpScreen
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
    val viewModel = hiltViewModel<AppViewModel>()
    NavHost(
        navController = navController,
        startDestination = AppScreens.SignUpScreen.name,
        modifier = Modifier
    ) {
        composable(route = AppScreens.ProfileScreen.name){
            ProfileScreen(navController, viewModel)
        }
        composable(route = AppScreens.LoginScreen.name){
            LoginScreen(navController, viewModel)
        }
        composable(route = AppScreens.ChatListScreen.name){
            ChatListScreen(navController, viewModel)
        }
        composable(route = AppScreens.StatusListScreen.name){
            StatusListScreen()
        }
        composable(route = AppScreens.SignUpScreen.name){
            SignUpScreen(navController,viewModel)
        }
        composable(route = AppScreens.SingleChatScreen.name){
            SingleChatScreen()
        }
        composable(route = AppScreens.SingleStatusScreen.name){
            SingleStatusScreen()
        }


    }
}