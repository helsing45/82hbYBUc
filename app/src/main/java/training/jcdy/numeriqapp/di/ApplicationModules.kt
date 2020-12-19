package training.jcdy.numeriqapp.di

import okhttp3.OkHttpClient
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.mapstruct.factory.Mappers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import training.jcdy.numeriqapp.MainViewModel
import training.jcdy.numeriqapp.data.articles.ArticleRepository
import training.jcdy.numeriqapp.data.articles.ArticleRepositoryImpl
import training.jcdy.numeriqapp.data.articles.mapper.ArticleMapper
import training.jcdy.numeriqapp.data.articles.retrofit.ArticleAPI

val applicationModule by lazy {
    arrayOf(
        mapperModules,
        repositoryModules,
        webServiceModules,
        viewModelModules
    )
}

private val mapperModules = module {
    single { Mappers.getMapper(ArticleMapper::class.java) }
}

private val repositoryModules = module {
    factory<ArticleRepository> { ArticleRepositoryImpl(get(), get()) }
}

private val webServiceModules = module {
    single { createWebService<ArticleAPI>(get()) }
    single { createRetrofit(get()) }
    single { createHttpClient() }
}

private inline fun createRetrofit(httpClient: OkHttpClient) =
    Retrofit.Builder()
        .baseUrl("http://newsapi.org/v2/")
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


private inline fun createHttpClient(): OkHttpClient {
    return OkHttpClient.Builder().build()
}

internal inline fun <reified T> createWebService(retrofit: Retrofit) =
    retrofit.create(T::class.java)

private val viewModelModules = module {
    viewModel { MainViewModel(get()) }
}