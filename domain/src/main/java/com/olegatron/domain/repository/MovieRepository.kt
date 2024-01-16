package com.olegatron.domain.repository

import com.olegatron.domain.model.Movie

interface MovieRepository {
    suspend fun getPopularMovies(page: Int): List<Movie>
}