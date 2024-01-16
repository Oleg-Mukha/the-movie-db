package com.olegatron.data.repository

import android.util.Log
import com.olegatron.data.api.MoviesApi
import com.olegatron.domain.model.Movie
import com.olegatron.domain.repository.MovieRepository

class MovieRepositoryImpl(private val moviesApi: MoviesApi) : MovieRepository {
    override suspend fun getPopularMovies(): List<Movie> {
        val response = moviesApi.getPopularMovies()
        return response.results.map { it.convert() }
    }

}
