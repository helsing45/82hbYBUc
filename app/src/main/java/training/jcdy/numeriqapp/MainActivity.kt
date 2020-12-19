package training.jcdy.numeriqapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.koin.android.viewmodel.ext.android.viewModel
import training.jcdy.numeriqapp.data.articles.model.Article
import training.jcdy.numeriqapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var _viewBinding: ActivityMainBinding
    private val _viewModel: MainViewModel by viewModel();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_viewBinding.root)
        _viewModel.getArticles().observe(this, this::onArticlesReceived)
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