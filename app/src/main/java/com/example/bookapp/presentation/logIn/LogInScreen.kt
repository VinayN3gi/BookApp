package com.example.bookapp.presentation.logIn

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.bookapp.domain.Routes
import com.example.bookapp.presentation.components.LoadingCircle
import com.example.bookapp.presentation.icons.Lock
import com.example.bookapp.presentation.icons.Person
import com.example.bookapp.ui.theme.signikaFontFamily
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@Composable
fun LogInScreen(logInViewModel: LogInViewModel= hiltViewModel(),navController: NavController)
{

    val password= logInViewModel.password.collectAsState()
    val email= logInViewModel.email.collectAsState()
    val loading=logInViewModel.loading.collectAsState()
    val coroutineScope= rememberCoroutineScope()

    LaunchedEffect(logInViewModel.navigationEvent) {
        logInViewModel.navigationEvent.collect{
            route->
            navController.navigate(route)
        }
    }


    Column(modifier = Modifier.fillMaxSize().systemBarsPadding().navigationBarsPadding().padding(horizontal = 20.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text(text="Sign In", fontFamily = signikaFontFamily, fontWeight = FontWeight.SemiBold, fontSize = 50.sp, modifier = Modifier.fillMaxWidth(.9f), textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(40.dp))

        //Email text field
        TextField(onValueChange = {
            logInViewModel.changeEmail(it)
        },
            value = email.value,
            textStyle = TextStyle(
                fontFamily = signikaFontFamily,
                fontWeight = FontWeight.Light,
                fontSize = 20.sp
            ),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Gray,
                focusedTextColor = Color.Black
            ),
            modifier = Modifier.fillMaxWidth(.9f),
            leadingIcon = {
                Image(imageVector = Person,contentDescription = "PersonIcon",modifier = Modifier.size(22.dp))
            },
            placeholder = {
                Text(text = "Email", fontFamily = signikaFontFamily, fontWeight = FontWeight.Light, fontSize = 20.sp)
            }
        )

        Spacer(modifier = Modifier.height(40.dp))

        //Password text field
        TextField(onValueChange = {
            logInViewModel.changePassword(it)
        },
            value = password.value,
            textStyle = TextStyle(
                fontFamily = signikaFontFamily,
                fontWeight = FontWeight.Light,
                fontSize = 20.sp
            ),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Gray,
                focusedTextColor = Color.Black
            ),
            modifier = Modifier.fillMaxWidth(.9f),
            leadingIcon = {
                Image(imageVector = Lock,contentDescription = "LockIcon",modifier = Modifier.size(22.dp))
            },
            placeholder = {
                Text(text = "Password", fontFamily = signikaFontFamily, fontWeight = FontWeight.Light, fontSize = 20.sp)
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center)
        {
            Text(text="Don't have an account ?", fontFamily = signikaFontFamily, fontWeight = FontWeight.Normal, fontSize = 18.sp)
            Spacer(modifier = Modifier.width(4.dp))
            Text(text="Register Here", fontFamily = signikaFontFamily,
                modifier = Modifier.clickable {
                    navController.navigate(Routes.SignIn.routes)
                },
                fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color(0xFF9C27B0))
        }

        Spacer(modifier = Modifier.height(35.dp))

        Button(onClick = {
            coroutineScope.launch {
                logInViewModel.loginUser()
            }

        },
            modifier = Modifier.fillMaxWidth(.6f).height(45.dp), shape = RoundedCornerShape(2.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            )
        ) {
            if(loading.value)
            {
                LoadingCircle()
            }
            else{
                Text(text="Sign Up", fontFamily = signikaFontFamily, fontSize = 20.sp, fontWeight = FontWeight.Normal, color = Color.White)
            }

        }

    }
}



