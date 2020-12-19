package training.jcdy.data.articles.mapper

import org.mapstruct.Mapper
import training.jcdy.data.articles.dto.ArticleDTO
import training.jcdy.data.articles.model.Article
import training.jcdy.data.articles.model.Source
import training.jcdy.data.articles.dto.NewsSearchResponseDTO
import training.jcdy.data.articles.dto.SourceDTO

@Mapper
abstract class ArticleMapper {

    fun toArticles(dto: NewsSearchResponseDTO):List<Article>
    {
        if(dto.articles == null)
            return emptyList()
        val result = mutableListOf<Article>()
        dto.articles?.forEach {
            result.add(toArticleModel(it))
        }
        return result;
    }

    abstract fun toSourceModel(dto: SourceDTO):Source

    abstract fun toArticleModel(dto: ArticleDTO):Article
}