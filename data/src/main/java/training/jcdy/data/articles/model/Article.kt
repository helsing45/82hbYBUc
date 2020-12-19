package training.jcdy.data.articles.model

import training.jcdy.data.articles.dto.SourceDTO


data class Article(
    var source: Source? = null,
    var author: String? = null,
    var title: String? = null,
    var description: String? = null,
    var url: String? = null,
    var urlToImage: String? = null,
    var publishedAt: Long? = null,
    var content: String? = null
)