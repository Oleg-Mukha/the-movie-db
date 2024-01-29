package com.olegatron.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.olegatron.data.db.dao.LikesDao
import com.olegatron.data.db.data.Like

@Database(entities = [Like::class], version = 1)
abstract class LikeDatabase : RoomDatabase() {
    abstract fun likesDao(): LikesDao
}