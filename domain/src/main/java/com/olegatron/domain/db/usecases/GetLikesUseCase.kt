package com.olegatron.domain.db.usecases

import com.olegatron.domain.db.data.Like
import com.olegatron.domain.db.repository.LikesRepository

class GetLikesUseCase(private val likesRepository: LikesRepository) {
    suspend operator fun invoke(): List<Like> {
        return likesRepository.getLikes()
    }
}