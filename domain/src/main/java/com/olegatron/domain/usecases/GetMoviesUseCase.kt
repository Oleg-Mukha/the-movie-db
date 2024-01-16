package com.olegatron.domain.usecases

import com.olegatron.domain.model.Movie
import com.olegatron.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend operator fun invoke(page: Int): List<Movie> {
        return movieRepository.getPopularMovies(page)
    }
}
