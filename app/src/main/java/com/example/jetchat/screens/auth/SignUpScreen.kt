package com.example.jetchat.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.jetchat.AppViewModel
import com.example.jetchat.R


@Composable
fun SignUpScreen(
    navController: NavHostController,
    viewModel: AppViewModel

) {
    val chatIconColor = if(isSystemInDarkTheme()){
        colorResource(id = R.color.white)
    }else{
        colorResource(id = R.color.black)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(
                rememberScrollState()
            )
    ) {
        Spacer(modifier = Modifier.height(60.dp))
        Image(painter = painterResource(id = R.drawable.chat_icon), contentDescription = "Icon",
            modifier=Modifier.size(100.dp), colorFilter = ColorFilter.tint(chatIconColor))
        Spacer(modifier = Modifier.height(20.dp))
        Text("Sign Up", modifier = Modifier.padding(4.dp), fontSize = 25.sp)
        val context = LocalContext.current
        UserForm(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            onButtonClick = { name, number, email, password ->
                            viewModel.signUpUser(name,number,email,password)
            },
            buttonText = "Sign Up",
            newUserText = "Already have an account? ",
            signUpText = "Sign In",
            signUpTextOnClick = {
                navController.navigate("LoginScreen")
            }
        )
    }
}