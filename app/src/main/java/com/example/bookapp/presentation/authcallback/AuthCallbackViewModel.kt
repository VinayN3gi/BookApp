package com.example.bookapp.presentation.authcallback

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthCallbackViewModel @Inject constructor(private val firebaseAuth: FirebaseAuth): ViewModel() {

    private val _id= MutableStateFlow<String>("Loading")
    val id:StateFlow<String> = _id


    private fun getId()
    {
        val user: FirebaseUser?=firebaseAuth.currentUser


        if(user==null)
        {
            _id.value="User id is null"
            return;
        }

        _id.value=user.uid

    }

    init {

        viewModelScope.launch {
            getId()
        }
    }



}