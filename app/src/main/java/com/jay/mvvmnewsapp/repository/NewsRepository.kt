package com.jay.mvvmnewsapp.repository

import com.jay.mvvmnewsapp.api.NewsApi
import com.jay.mvvmnewsapp.api.RetrofitInstance
import com.jay.mvvmnewsapp.db.ArticleDao
import com.jay.mvvmnewsapp.db.ArticleDatabase
import com.jay.mvvmnewsapp.model.Article
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val api: NewsApi, //AuthApi is the retrofit interface
    //val db: ArticleDatabase
    private val db: ArticleDao,
) {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        api.getBreakingNews()

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        api.searchForNews(searchQuery, pageNumber)


    suspend fun upsert(article: Article) = db.upsert(article)

    fun getSavedNews() = db.getAllArticles()

    suspend fun deleteArticle(article: Article) = db.deleteArticle(article)
}