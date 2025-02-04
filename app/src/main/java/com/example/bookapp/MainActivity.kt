package com.example.bookapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bookapp.domain.Routes
import com.example.bookapp.presentation.logIn.LogInScreen
import com.example.bookapp.presentation.signIn.SignInScreen
import com.example.bookapp.ui.theme.BookAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BookAppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Routes.SignIn.routes)
                {
                    composable(Routes.SignIn.routes)
                    {
                        SignInScreen(navController)
                    }

                    composable(Routes.LogIn.routes)
                    {
                        LogInScreen()
                    }

                }

            }
        }
    }
}

