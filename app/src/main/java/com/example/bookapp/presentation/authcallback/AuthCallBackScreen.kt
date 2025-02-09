package com.example.bookapp.presentation.authcallback

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bookapp.domain.Routes
import com.google.firebase.auth.FirebaseAuth

@Composable
fun AuthCallbackScreen(navController: NavController) {

    val id= remember { mutableStateOf<String?>(null) }

    Column(modifier = Modifier.fillMaxWidth().systemBarsPadding().navigationBarsPadding())
    {

        

    }


}



@Composable
@Preview(showBackground = true, showSystemUi = true)
fun AuthCallbackPreview()
{
    val navController= rememberNavController()
    AuthCallbackScreen(navController = navController)
}




