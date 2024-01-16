package com.olegatron.data.di

import com.olegatron.data.api.MoviesApi
import com.olegatron.data.di.interceptor.MovieInterceptor
import com.olegatron.data.repository.MovieRepositoryImpl
import org.koin.dsl.module
import com.olegatron.domain.repository.MovieRepository
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val URL = "https://api.themoviedb.org/3/"

val movieDataModule = module {
    factory<MovieRepository> { MovieRepositoryImpl(get()) }

    single<MoviesApi> {
        val client = OkHttpClient.Builder()
            .addInterceptor(MovieInterceptor())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        return@single retrofit.create(MoviesApi::class.java)
    }
}