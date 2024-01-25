package com.olegatron.domain.usecases

import com.olegatron.domain.model.Movie
import com.olegatron.domain.repository.MovieRepository

class GetMovieUseCase(private val movieRepository: MovieRepository) {
    suspend operator fun invoke(id: Int): Movie {
        return movieRepository.getMovie(id)
    }
}