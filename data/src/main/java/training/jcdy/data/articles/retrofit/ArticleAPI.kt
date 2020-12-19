package training.jcdy.data.articles.retrofit

import io.reactivex.Single
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import training.jcdy.data.articles.dto.NewsSearchResponseDTO

interface ArticleAPI {

    /*q:bitcoin
from:2020-11-19
sortBy:publishedAt
apiKey:25a2abdea2624a55b01944d73fa9dc52*/
    @GET("everything")
    fun getArticles(
        @Query("q") q: String?,
        @Query("from") from: String?,
        @Query("sortBy") sortBy: String?,
        @Query("apiKey") apiKey: String?
    ): Call<NewsSearchResponseDTO>
}