package training.jcdy.numeriqapp.data.articles.model

data class Article(
    var source: Source? = null,
    var author: String? = null,
    var title: String? = null,
    var description: String? = null,
    var url: String? = null,
    var urlToImage: String? = null,
    var publishedAt: String? = null,//UPGRADE use a long so the UI can choose de format
    var content: String? = null
)