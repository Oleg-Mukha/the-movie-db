package com.olegatron.domain.repository

import com.olegatron.domain.model.Credit
import com.olegatron.domain.model.Movie

interface MovieRepository {
    suspend fun getPopularMovies(page: Int): List<Movie>
    suspend fun getMovie(id: Int): Movie
    suspend fun getCredits(movieId: Int): List<Credit>
}