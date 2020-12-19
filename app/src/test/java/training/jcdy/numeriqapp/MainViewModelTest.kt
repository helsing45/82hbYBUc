package training.jcdy.numeriqapp

import org.junit.Assert
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.Mockito
import training.jcdy.numeriqapp.data.articles.ArticleRepository
import training.jcdy.numeriqapp.data.articles.ArticleRepositoryImpl
import training.jcdy.numeriqapp.data.articles.mapper.ArticleMapper
import training.jcdy.numeriqapp.data.articles.retrofit.ApiKeyProvider


class MainViewModelTest {

    private val MOCK_API_KEY = "mock-api-key"
    private lateinit var _vm: MainViewModel
    private lateinit var _repository: ArticleRepository

    @Test
    fun whenAskedForArticle_thenRepositoryIsCalled() {
        _repository = Mockito.mock(ArticleRepository::class.java)
        _vm = MainViewModel(_repository)
        _vm.getArticles()
        Mockito.verify(_repository).fetchArticles()
    }

    @Test
    fun whenAskedForArticle_thenWebServiceIsCalledWithQueryBitcoin() {
        val mapper = Mockito.mock(ArticleMapper::class.java)
        val webService = Mockito.spy(MockArticleWebService())
        val apiKeyProvider = Mockito.mock(ApiKeyProvider::class.java)
        val repository = ArticleRepositoryImpl(mapper, webService, apiKeyProvider)

        _vm = MainViewModel(repository)

        _vm.getArticles()
        val argsCaptor = ArgumentCaptor.forClass(String::class.java)
        Mockito.verify(webService).getArticles(
            argsCaptor.capture(),
            argsCaptor.capture(),
            argsCaptor.capture(),
            argsCaptor.capture()

        )

        var results = argsCaptor.allValues

        Assert.assertEquals("bitcoin", results.get(0))
    }

    @Test
    fun whenAskedForArticle_thenWebServiceIsCalledWithDateEqualTo19November2020() {
        val mapper = Mockito.mock(ArticleMapper::class.java)
        val webService = Mockito.spy(MockArticleWebService())
        val apiKeyProvider = Mockito.mock(ApiKeyProvider::class.java)
        val repository = ArticleRepositoryImpl(mapper, webService, apiKeyProvider)

        _vm = MainViewModel(repository)

        _vm.getArticles()
        val argsCaptor = ArgumentCaptor.forClass(String::class.java)
        Mockito.verify(webService).getArticles(
            argsCaptor.capture(),
            argsCaptor.capture(),
            argsCaptor.capture(),
            argsCaptor.capture()

        )

        var results = argsCaptor.allValues

        Assert.assertEquals("2020-11-19", results.get(1))
    }

    @Test
    fun whenAskedForArticle_thenWebServiceIsCalledWithSortByPublishedAt() {
        val mapper = Mockito.mock(ArticleMapper::class.java)
        val webService = Mockito.spy(MockArticleWebService())
        val apiKeyProvider = Mockito.mock(ApiKeyProvider::class.java)
        val repository = ArticleRepositoryImpl(mapper, webService, apiKeyProvider)

        _vm = MainViewModel(repository)

        _vm.getArticles()
        val argsCaptor = ArgumentCaptor.forClass(String::class.java)
        Mockito.verify(webService).getArticles(
            argsCaptor.capture(),
            argsCaptor.capture(),
            argsCaptor.capture(),
            argsCaptor.capture()

        )

        var results = argsCaptor.allValues

        Assert.assertEquals("publishedAt", results.get(2))
    }

    @Test
    fun whenAskedForArticle_thenWebServiceIsCalledApiKeyProvided() {
        val mapper = Mockito.mock(ArticleMapper::class.java)
        val webService = Mockito.spy(MockArticleWebService())
        val apiKeyProvider = Mockito.mock(ApiKeyProvider::class.java)
        val repository = ArticleRepositoryImpl(mapper, webService, apiKeyProvider)
        Mockito.`when`(apiKeyProvider.getApiKey()).thenReturn(MOCK_API_KEY)

        _vm = MainViewModel(repository)

        _vm.getArticles()
        val argsCaptor = ArgumentCaptor.forClass(String::class.java)
        Mockito.verify(webService).getArticles(
            argsCaptor.capture(),
            argsCaptor.capture(),
            argsCaptor.capture(),
            argsCaptor.capture()

        )

        var results = argsCaptor.allValues

        Assert.assertEquals(MOCK_API_KEY, results.get(3))
    }
}