package com.olegatron.data.db.di

import androidx.room.Room
import com.olegatron.data.db.LikeDatabase
import com.olegatron.data.db.dao.LikesDao
import com.olegatron.data.db.repository.LikeRepositoryImpl
import com.olegatron.domain.db.repository.LikesRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    factory<LikesRepository> { LikeRepositoryImpl(get()) }

    single<LikeDatabase> {
        Room.databaseBuilder(
            androidContext(),
            LikeDatabase::class.java,
            "LikesDB"
        ).build()
    }

    single<LikesDao> { get<LikeDatabase>().likesDao() }
}