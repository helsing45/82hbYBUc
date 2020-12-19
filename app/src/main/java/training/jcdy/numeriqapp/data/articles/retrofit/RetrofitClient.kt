package training.jcdy.numeriqapp.data.articles.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {
    const val MainServer = "http://newsapi.org/v2/"

    val retrofitClient: Retrofit.Builder by lazy {

        val okhttpClient = OkHttpClient.Builder()

        Retrofit.Builder()
            .baseUrl(MainServer)
            .client(okhttpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
    }

    val WEB_SERVICE_INTERFACE: ArticleWebService by lazy {
        retrofitClient
            .build()
            .create(ArticleWebService::class.java)
    }
}