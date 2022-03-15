package com.jay.mvvmnewsapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(
    tableName = "articles"
)
data class Article(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: Source?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
) : Serializable
// To add onClick functionality to the recyclerview. And Display in WebView.
// After making the model class Serializable, Go to news_nav_graph.xml and from the design view select
// on Arguments and add a new one. In the window add the argument name and then select argument type as
// Custom Serializable. Rest keep it the way it is. Now make changes in the BreakingNewsFragment.kt. Also
// we need to make changes in ArticleNewsFragment.kt for navArgs()