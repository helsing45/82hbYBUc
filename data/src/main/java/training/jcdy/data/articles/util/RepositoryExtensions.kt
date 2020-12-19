package training.jcdy.data.articles.util

import io.reactivex.Maybe
import io.reactivex.Single
import retrofit2.Response

inline fun <T, R> Single<Response<T?>>.transform(crossinline transformation: (T) -> R): Single<R> =
    map { it.transform(transformation) }

inline fun <T, R> Maybe<Response<T?>>.transform(crossinline transformation: (T) -> R): Maybe<R> =
    map { it.transform(transformation) }

inline fun <T, R> Response<T?>.transform(transformation: (T) -> R): R? {
    if (!isSuccessful)
        throw HttpException(this)

    return body()?.let {
        transformation(it)
    }
}