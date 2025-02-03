package com.example.bookapp.presentation.logIn

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LogInScreen()
{
    Column(modifier = Modifier.fillMaxSize().systemBarsPadding().navigationBarsPadding())
    {
        Text(text="Log In")
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun LogInScreenPreview()
{
    LogInScreen()
}

