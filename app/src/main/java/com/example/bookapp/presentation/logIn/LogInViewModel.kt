package com.example.bookapp.presentation.logIn

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor():ViewModel() {
    private val _email=MutableStateFlow<String>("")
    private val _password= MutableStateFlow<String>("")

    val email:StateFlow<String> =_email
    val password:StateFlow<String> = _password



    fun changeEmail(it:String)
    {
        _email.value=it
    }


    fun changePassword(it:String)
    {
        _password.value=it

    }

}