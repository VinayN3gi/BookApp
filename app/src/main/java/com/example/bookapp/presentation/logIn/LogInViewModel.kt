package com.example.bookapp.presentation.logIn

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.bookapp.domain.Routes
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor(private val firebaseAuth: FirebaseAuth):ViewModel() {
    private val _email=MutableStateFlow<String>("")
    private val _password= MutableStateFlow<String>("")
    private val _loading= MutableStateFlow<Boolean>(false)
    private val _navigationEvent= MutableSharedFlow<String>()

    val email:StateFlow<String> =_email
    val password:StateFlow<String> = _password
    val loading:StateFlow<Boolean> = _loading
    val navigationEvent:SharedFlow<String> = _navigationEvent


    fun changeEmail(it:String)
    {
        _email.value=it
    }


    fun changePassword(it:String)
    {
        _password.value=it

    }

    suspend fun loginUser()
    {
        _loading.value=true
        try{
            val authResult=firebaseAuth.signInWithEmailAndPassword(email.value,password.value).await()
            val user:FirebaseUser?=authResult.user
            Log.d("Tag","User logged in ${user?.uid}")
            _navigationEvent.emit(Routes.AuthCallback.routes)
        }
        catch (err:Exception)
        {
            Log.d("Tag",err.message.toString())
        }
        _loading.value=false
    }

}