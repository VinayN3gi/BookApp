package com.example.bookapp.presentation.signIn

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow

@HiltViewModel
class SignInViewModel():ViewModel() {

    private val _email=MutableStateFlow<String>("")
    private val _password=MutableStateFlow<String>("")

    val email=_email.value
    val password=_password.value



}