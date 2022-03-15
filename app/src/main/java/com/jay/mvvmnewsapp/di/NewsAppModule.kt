package com.jay.mvvmnewsapp.di

import android.content.Context
import androidx.room.Room
import com.jay.mvvmnewsapp.api.NewsApi
import com.jay.mvvmnewsapp.api.RetrofitInstance
import com.jay.mvvmnewsapp.db.ArticleDao
import com.jay.mvvmnewsapp.db.ArticleDatabase
import com.jay.mvvmnewsapp.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NewsAppModule {

    @Singleton
    @Provides
    fun provideRetrofitInstance(
        retrofitInstance: RetrofitInstance
    ):NewsApi{
        return retrofitInstance.buildApi(NewsApi::class.java)
    }

    @Provides
    @Singleton //Singleton as it provides only single instance of database object
    fun providesDatabase(@ApplicationContext context: Context) : ArticleDatabase =
        Room.databaseBuilder(context, ArticleDatabase::class.java, "article_db")
            .build()

    @Provides
    fun providesUserDao(articleDatabase: ArticleDatabase) : ArticleDao =
        articleDatabase.getArticleDao()



    @Provides
    fun providesUserRepository(api: NewsApi, articleDao: ArticleDao): NewsRepository =
        NewsRepository(api, articleDao)

}