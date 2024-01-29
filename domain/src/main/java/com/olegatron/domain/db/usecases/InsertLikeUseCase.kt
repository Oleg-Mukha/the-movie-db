package com.olegatron.domain.db.usecases

import com.olegatron.domain.db.data.Like
import com.olegatron.domain.db.repository.LikesRepository

class InsertLikeUseCase(private val likesRepository: LikesRepository) {
    suspend operator fun invoke(like: Like) {
        return likesRepository.insertLike(like)
    }
}