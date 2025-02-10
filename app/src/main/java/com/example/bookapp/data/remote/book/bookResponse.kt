package com.example.bookapp.data.remote.book

data class bookResponse(
    val books: List<Book>,
    val message: String
)