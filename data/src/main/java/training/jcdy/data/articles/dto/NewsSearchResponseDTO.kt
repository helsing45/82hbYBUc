package training.jcdy.data.articles.dto

data class NewsSearchResponseDTO(
    var status: String? = null,
    var totalResults: Int = -1,
    var articles: List<ArticleDTO>? = null
)
