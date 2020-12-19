package training.jcdy.numeriqapp.data.articles

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import training.jcdy.numeriqapp.data.articles.dto.NewsSearchResponseDTO
import training.jcdy.numeriqapp.data.articles.mapper.ArticleMapper
import training.jcdy.numeriqapp.data.articles.model.Article
import training.jcdy.numeriqapp.data.articles.retrofit.ArticleAPI

interface ArticleRepository{
    fun fetchArticles(): MutableLiveData<List<Article>>
}

class ArticleRepositoryImpl(
    private var _mapper:ArticleMapper,
    private var _webService:ArticleAPI
) : ArticleRepository{
    val articles = MutableLiveData<List<Article>>()

    override fun fetchArticles(): MutableLiveData<List<Article>> {
        val call = _webService.getArticles(
            "bitcoin",
            "2020-11-19",
            "publishedAt",
            "25a2abdea2624a55b01944d73fa9dc52"
        )
        call.enqueue(object : Callback<NewsSearchResponseDTO> {
            override fun onResponse(
                call: Call<NewsSearchResponseDTO>,
                response: Response<NewsSearchResponseDTO>
            ) {
                articles.value = response.body()?.let { _mapper.toArticles(it) }
            }

            override fun onFailure(call: Call<NewsSearchResponseDTO>, t: Throwable) {
                articles.value = emptyList()
            }
        })
        return articles
    }
}