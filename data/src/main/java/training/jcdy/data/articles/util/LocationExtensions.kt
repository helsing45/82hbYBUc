@file:Suppress("NOTHING_TO_INLINE")

package training.jcdy.data.articles.util

import android.location.Location

inline fun Location.distanceTo(latitude: Float?, longitude: Float?): Float? {
    if (latitude == null || longitude == null) return null

    val results = FloatArray(1)
    android.location.Location.distanceBetween(this.latitude, this.longitude, latitude.toDouble(), longitude.toDouble(), results)
    return results[0] / 1609.344f
}