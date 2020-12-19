package training.jcdy.numeriqapp

import com.google.gson.Gson
import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import training.jcdy.numeriqapp.data.articles.dto.NewsSearchResponseDTO
import training.jcdy.numeriqapp.data.articles.retrofit.ArticleWebService


class MockArticleWebService:ArticleWebService {
    override fun getArticles(
        q: String?,
        from: String?,
        sortBy: String?,
        apiKey: String?
    ): Call<NewsSearchResponseDTO> {
        return object: Call<NewsSearchResponseDTO>{
            override fun enqueue(callback: Callback<NewsSearchResponseDTO>?) {
            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun clone(): Call<NewsSearchResponseDTO> {
                return this
            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun cancel() {

            }

            override fun request(): Request {
                return Request.Builder().build()
            }

            override fun execute(): Response<NewsSearchResponseDTO> {
                // Create your mock data in here
                val response = "{ \"Response\": \"SomeUserValue\" }"
                val gson = Gson().toJson(response)
                return Response.success(NewsSearchResponseDTO(gson))
            }

            override fun timeout(): Timeout {
                return Timeout()
            }
        }
    }
}