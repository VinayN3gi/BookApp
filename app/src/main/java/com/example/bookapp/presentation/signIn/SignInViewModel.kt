package com.example.bookapp.presentation.signIn

import android.util.Log
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bookapp.data.remote.user.User
import com.example.bookapp.data.remote.user.UserApiInterface
import com.example.bookapp.data.remote.user.UserReponse
import com.example.bookapp.domain.Routes
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(private val userApiInterface: UserApiInterface, private val firebaseAuth: FirebaseAuth):ViewModel() {

    private val _email=MutableStateFlow<String>("")
    private val _password=MutableStateFlow<String>("")
    private val _loading=MutableStateFlow<Boolean>(false)
    private val _navigationEvent= MutableSharedFlow<String>()

    val email: StateFlow<String> =_email
    val password:StateFlow<String> =_password
    val loading:StateFlow<Boolean> =_loading
    val navigationEvent: SharedFlow<String> =_navigationEvent

    fun changeEmail(it:String)
    {
        _email.value=it
    }

    fun changePassword(it:String)
    {
        _password.value=it
    }

    suspend fun createUser()
    {
            _loading.value=true;
            try{
                val authResult=firebaseAuth.createUserWithEmailAndPassword(email.value,password.value).await()
                val user:FirebaseUser?=authResult.user
                Log.d("Tag","User logged in ${user?.uid}")

                if(user==null)
                {
                    _navigationEvent.emit(Routes.AuthCallback.routes)
                }
                if (user != null) {
                    val response = userApiInterface.postUser(User(email=email.value,id=user.uid,password=password.value))
                    Log.d("Tag",response.body()?.user.toString())
                    _navigationEvent.emit(Routes.AuthCallback.routes)
                }

            }
            catch (err:Exception)
            {
                Log.d("Tag",err.message.toString())
            }
            _loading.value=false
    }




}