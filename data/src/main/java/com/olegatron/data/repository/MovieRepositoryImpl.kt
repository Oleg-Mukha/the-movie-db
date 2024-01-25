package com.olegatron.data.repository

import com.olegatron.data.api.MoviesApi
import com.olegatron.domain.model.Credit
import com.olegatron.domain.model.Movie
import com.olegatron.domain.repository.MovieRepository

class MovieRepositoryImpl(private val moviesApi: MoviesApi) : MovieRepository {
    override suspend fun getPopularMovies(page: Int): List<Movie> {
        val response = moviesApi.getPopularMovies(page)
        return response.results.map { it.convert() }
    }

    override suspend fun getMovie(id: Int): Movie {
        val response = moviesApi.getMovie(id)
        return response.convert()
    }

    override suspend fun getCredits(movieId: Int): List<Credit> {
        val response = moviesApi.getCredits(movieId)
        return response.cast.map { it.convert() }
    }
}
