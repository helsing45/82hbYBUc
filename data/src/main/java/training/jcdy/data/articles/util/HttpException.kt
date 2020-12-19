package training.jcdy.data.articles.util

import retrofit2.Response

class HttpException(response: Response<*>) : RuntimeException("HTTP ${response.code()} ${response.message()}") {

    val code = response.code()
    val body = response.errorBody()?.let { if (it.contentLength() > 0) it.string() else null }
}