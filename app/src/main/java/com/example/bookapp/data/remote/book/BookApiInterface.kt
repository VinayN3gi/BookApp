package com.example.bookapp.data.remote.book

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface BookApiInterface {

    @GET("/book/curr")
    suspend fun getCurrentlyReadingBooks(@Query ("userId") userId:String):Response<bookResponse>

    @POST("/book/curr")
    suspend fun addCurrentlyReadingBook(@Body book: Book):Response<Book>

}