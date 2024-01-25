package com.olegatron.domain.usecases

import com.olegatron.domain.model.Credit
import com.olegatron.domain.repository.MovieRepository

class GetCreditsUseCase(private val movieRepository: MovieRepository) {
    suspend operator fun invoke(id: Int): List<Credit>{
        return movieRepository.getCredits(id)
    }
}