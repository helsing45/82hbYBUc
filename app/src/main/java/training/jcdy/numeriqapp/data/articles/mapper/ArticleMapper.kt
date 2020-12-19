package training.jcdy.numeriqapp.data.articles.mapper

import org.mapstruct.Mapper
import training.jcdy.numeriqapp.data.articles.dto.ArticleDTO
import training.jcdy.numeriqapp.data.articles.dto.NewsSearchResponseDTO
import training.jcdy.numeriqapp.data.articles.dto.SourceDTO
import training.jcdy.numeriqapp.data.articles.model.Article
import training.jcdy.numeriqapp.data.articles.model.Source


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

    abstract fun toSourceModel(dto: SourceDTO): Source

    abstract fun toArticleModel(dto: ArticleDTO): Article
}