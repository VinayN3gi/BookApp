package com.example.bookapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bookapp.presentation.icons.LoaderCircle
import kotlinx.coroutines.delay

@Composable
fun LoadingCircle()
{
    val degree= produceState(initialValue = 0)
    {
        while(true)
        {
            delay(16)
            value=(value+10) % 360
        }
    }




    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally)
    {
        Image(imageVector = LoaderCircle, contentDescription = "", modifier = Modifier.size(30.dp).rotate(degree.value.toFloat()), colorFilter = ColorFilter.tint(Color.White))
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun LoadingCirclePreview()
{
    Column(modifier = Modifier.fillMaxSize().systemBarsPadding().navigationBarsPadding())
    {
        LoadingCircle()
    }

}