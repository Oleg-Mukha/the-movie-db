package com.olegatron.domain.model

data class Movie(
    val id: Int?,
    val title: String?,
    val poster: String?,
    val background: String?,
    val overview: String?,
    val releaseDate: String?,
    val runtime: Double?,
    val vote: Double?
)