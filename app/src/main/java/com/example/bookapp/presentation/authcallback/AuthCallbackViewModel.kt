package com.example.bookapp.presentation.authcallback

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookapp.data.remote.user.UserApiInterface
import com.example.bookapp.domain.Routes
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthCallbackViewModel @Inject constructor(private val firebaseAuth: FirebaseAuth,private val userApiInterface: UserApiInterface): ViewModel() {

    private val _id= MutableStateFlow<String?>("")
    val id:StateFlow<String?> = _id

    private val _navigationEvent= MutableSharedFlow<String>()
    val navigationEvent: SharedFlow<String> = _navigationEvent

    private val _isLoading=MutableStateFlow<Boolean>(false)
    val isLoading:StateFlow<Boolean> = _isLoading

    suspend  fun goBack()
    {
        _navigationEvent.emit(Routes.SignIn.routes)
    }

    private suspend fun getUser()
    {
        val user=firebaseAuth.currentUser
        Log.d("Tag",user?.uid.toString())

        if(user==null)
        {
            _id.value=null
            return;
        }

        else{
            _isLoading.value=true
            try{
                val user=userApiInterface.getUser(user.uid)

                if(user!=null)
                {
                    Log.d("Tag",user.body()?.user.toString())
                    _id.value=user.body()?.user?.id
                    _navigationEvent.emit(Routes.Home.routes)
                }
                else{
                    _id.value=null
                }
            }
            catch (err:Exception)
            {
                Log.d("Tag",err.message.toString())
                _id.value=null
            }
            _isLoading.value=false
        }

    }

    init{
        viewModelScope.launch {
            getUser()
        }
    }

}