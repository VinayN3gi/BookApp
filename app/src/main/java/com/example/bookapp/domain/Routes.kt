package com.example.bookapp.domain

sealed class Routes(val routes:String)
{
    data object SignIn:Routes("signIn")
    data object LogIn:Routes("logIn")
    data object AuthCallback:Routes("authCallback")
}

