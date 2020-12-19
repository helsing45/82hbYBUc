package training.jcdy.numeriqapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import training.jcdy.numeriqapp.data.articles.ArticleRepository
import training.jcdy.numeriqapp.data.articles.model.Article

 class MainViewModel(
    private val _repository: ArticleRepository
) : ViewModel() {

    fun getArticles(): LiveData<List<Article>> {
        return _repository.fetchArticles()
    }
}