package com.example.bookapp.presentation.logIn

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor(private val firebaseAuth: FirebaseAuth):ViewModel() {
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

    suspend fun loginUser()
    {
        try{

            val user=firebaseAuth.signInWithEmailAndPassword(email.value,password.value)
            Log.d("Tag","User logged in $user")

        }
        catch (err:Exception)
        {
            Log.d("Tag",err.message.toString())
        }
    }

}