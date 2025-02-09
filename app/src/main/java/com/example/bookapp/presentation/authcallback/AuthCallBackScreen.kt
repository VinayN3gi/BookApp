package com.example.bookapp.presentation.authcallback

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bookapp.presentation.components.LoadingCircle
import com.example.bookapp.presentation.icons.Error
import com.example.bookapp.ui.theme.signikaFontFamily
import kotlinx.coroutines.launch

@Composable
fun AuthCallbackScreen(navController: NavController,viewModel: AuthCallbackViewModel= hiltViewModel()) {

    val id= viewModel.id.collectAsState()
    val coroutineScope= rememberCoroutineScope()
    val loading=viewModel.isLoading.collectAsState()


    LaunchedEffect(viewModel.navigationEvent)
    {
        viewModel.navigationEvent.collect{
            route->
            navController.navigate(route)
        }
    }


    Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp).systemBarsPadding().navigationBarsPadding())
    {

        if(loading.value)
        {
            Column(modifier = Modifier.fillMaxSize()) {
                Spacer(modifier = Modifier.height(20.dp))
                LoadingCircle(Color.Black,30)
                Spacer(modifier = Modifier.height(20.dp))
                Text(text="Connecting to database", fontFamily = signikaFontFamily, fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
                Text(text="You will be automatically redirected", fontFamily = signikaFontFamily, fontSize = 20.sp)
            }
        }


        if(id.value==null)
        {
            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally)
            {
                Image(imageVector = Error, contentDescription = null, modifier = Modifier.size(50.dp), colorFilter = ColorFilter.tint(Color.Red))
                Spacer(modifier = Modifier.height(30.dp))

                Text(text="Unable to authenticate user please try again later", fontFamily = signikaFontFamily, fontSize = 20.sp, textAlign = TextAlign.Center)

                Spacer(modifier = Modifier.height(20.dp))

                Button(onClick = {
                    coroutineScope.launch {
                        viewModel.goBack()
                    }
                },
                    shape = RoundedCornerShape(2.dp), modifier = Modifier.fillMaxWidth(.6f), colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                )
                )
                {
                    Text(text="Go back", fontFamily = signikaFontFamily, fontSize = 15.sp)
                }

            }
        }
        else
        {
            Text(text=id.value.toString(), fontFamily = signikaFontFamily, fontSize = 20.sp)
        }


    }


}



@Composable
@Preview(showBackground = true, showSystemUi = true)
fun AuthCallbackPreview()
{
    val navController= rememberNavController()
    AuthCallbackScreen(navController = navController)
}




