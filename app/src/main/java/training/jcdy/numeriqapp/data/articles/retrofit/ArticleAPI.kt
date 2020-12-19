package training.jcdy.numeriqapp.data.articles.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import training.jcdy.numeriqapp.data.articles.dto.NewsSearchResponseDTO

interface ArticleAPI {

    @GET("everything")
    fun getArticles(
        @Query("q") q: String?,
        @Query("from") from: String?,
        @Query("sortBy") sortBy: String?,
        @Query("apiKey") apiKey: String?
    ): Call<NewsSearchResponseDTO>
}