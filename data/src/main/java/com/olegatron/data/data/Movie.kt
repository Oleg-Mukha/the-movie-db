package com.olegatron.data.data

import com.google.gson.annotations.SerializedName
import com.olegatron.domain.model.Movie

data class Movie(
    @SerializedName("id") val id: Int?,
    @SerializedName("original_title") val title: String?,
    @SerializedName("poster_path") val poster: String?,
    @SerializedName("backdrop_path") val background: String?,
    @SerializedName("overview") val overview: String?,
    @SerializedName("release_date") val releaseDate: String?,
    @SerializedName("runtime") val runtime: Double?,
    @SerializedName("vote_average") val vote: Double?,

) {
    fun convert(): Movie {
        val movie = this
        return Movie(
            movie.id,
            movie.title,
            movie.poster,
            movie.background,
            movie.overview,
            movie.releaseDate,
            movie.runtime,
            movie.vote
        )
    }
}

data class MovieResponse(
    @SerializedName("results") val results: List<com.olegatron.data.data.Movie>
)