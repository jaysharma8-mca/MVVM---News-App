package com.jay.mvvmnewsapp.model

data class NewsResponse(
    val articles: MutableList<Article>, //MutableList as we are handling pagination also
    val status: String,
    val totalResults: Int
)