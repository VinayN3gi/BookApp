package com.example.bookapp.data.remote.user

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UserApiInterface {

    @GET("/user")
    suspend fun getUser(@Query("id") id :String) : Response<UserReponse>

    @POST("/user")
    suspend fun  postUser(@Body user: User) : Response<UserReponse>


}