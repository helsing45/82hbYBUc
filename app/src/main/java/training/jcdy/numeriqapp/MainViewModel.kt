package training.jcdy.numeriqapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import training.jcdy.numeriqapp.data.articles.ArticleRepository
import training.jcdy.numeriqapp.data.articles.model.Article


class MainViewModel : ViewModel() {

    fun getArticles():LiveData<List<Article>>
    {
       return ArticleRepository.fetchArticles()
    }
}