package com.olegatron.domain.db.repository

import com.olegatron.domain.db.data.Like

interface LikesRepository {
    suspend fun getLikes(): List<Like>
    suspend fun getLikeMovie(id: Int): Like
    suspend fun insertLike(like: Like)
    suspend fun removeLike(id: Int)
}