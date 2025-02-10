package com.example.bookapp.data.remote.book

data class Book(
    val author: String,
    val cover: String,
    val description: String,
    val id: Int,
    val publishedYear: String,
    val title: String,
    val userId: String
)