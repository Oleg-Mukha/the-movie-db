package com.olegatron.domain.db.usecases

import com.olegatron.domain.db.data.Like
import com.olegatron.domain.db.repository.LikesRepository

class GetLikeUseCase(private val likesRepository: LikesRepository) {
    suspend operator fun invoke(movieId: Int): Like {
        return likesRepository.getLikeMovie(movieId)
    }
}