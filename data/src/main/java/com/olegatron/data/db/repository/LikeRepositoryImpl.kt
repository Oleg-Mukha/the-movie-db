package com.olegatron.data.db.repository

import com.olegatron.data.db.dao.LikesDao
import com.olegatron.domain.db.data.Like

import com.olegatron.domain.db.repository.LikesRepository

class LikeRepositoryImpl(private var likesDao: LikesDao) : LikesRepository {
    override suspend fun getLikes(): List<Like> = likesDao.getLikes().map { it.convert() }

    override suspend fun getLikeMovie(id: Int): Like = likesDao.getLikeMovie(id).convert()

    override suspend fun insertLike(like: Like) {
        val dataLike = com.olegatron.data.db.data.Like(id = like.movieId)
        return likesDao.insertLike(dataLike)
    }

    override suspend fun removeLike(id: Int) = likesDao.removeLike(id)
}