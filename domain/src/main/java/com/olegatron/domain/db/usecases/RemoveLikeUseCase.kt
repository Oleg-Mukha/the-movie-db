package com.olegatron.domain.db.usecases

import com.olegatron.domain.db.repository.LikesRepository

class RemoveLikeUseCase(private val likesRepository: LikesRepository) {
    suspend operator fun invoke(movieId: Int){
        return likesRepository.removeLike(movieId)
    }
}