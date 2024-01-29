package com.olegatron.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.olegatron.data.db.data.Like

@Dao
interface LikesDao {
    @Query("SELECT * FROM likes")
    suspend fun getLikes(): List<Like>
    @Query("SELECT * FROM likes WHERE id=:id")
    suspend fun getLikeMovie(id: Int): Like
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLike(like: Like)
    @Query("DELETE FROM likes WHERE id=:id")
    suspend fun removeLike(id: Int)
}