package training.jcdy.numeriqapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import training.jcdy.data.articles.model.Article
import training.jcdy.numeriqapp.databinding.ActivityMainBinding
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var _viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_viewBinding.root)
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getArticles().observe(this, this::onArticlesReceived)
    }

    private fun onArticlesReceived(articles: List<Article>?) {
        val builder = StringBuilder()
        articles?.forEach {
            builder.append(it.title)
            builder.append("\n")
        }
        _viewBinding.textView.text = builder.toString()
    }
}