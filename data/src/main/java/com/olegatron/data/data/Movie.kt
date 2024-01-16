package com.olegatron.data.data

import com.google.gson.annotations.SerializedName
import com.olegatron.domain.model.Movie

data class Movie(
    @SerializedName("id") val id: Int?,
    @SerializedName("original_title") val title: String?,
    @SerializedName("poster_path") val poster: String?,
) {
    fun convert(): Movie {
        val movie = this
        return Movie(
            movie.id,
            movie.title,
            movie.poster
        )
    }
}