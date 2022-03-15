package com.jay.mvvmnewsapp.ui.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.jay.mvvmnewsapp.databinding.FragmentArticleBinding
import com.jay.mvvmnewsapp.ui.base_fragment.BaseFragment
import com.jay.mvvmnewsapp.viewmodel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_article.*

@AndroidEntryPoint
class ArticleNewsFragment : BaseFragment<FragmentArticleBinding>(
    FragmentArticleBinding::inflate
) {

    private val viewModel by viewModels<NewsViewModel>()
    val args: ArticleNewsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val article = args.article
        webView.apply {
            webViewClient = WebViewClient()
            article.url?.let { loadUrl(it) }
        }

        fab.setOnClickListener {
            viewModel.saveArticle(article)
            Snackbar.make(view, "Article saved successfully", Snackbar.LENGTH_SHORT, ).show()
        }
    }
}