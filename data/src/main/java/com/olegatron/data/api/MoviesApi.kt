package com.olegatron.data.api

import com.olegatron.data.data.CreditResponse
import com.olegatron.data.data.Movie
import com.olegatron.data.data.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApi {
    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("page") page: Int): MovieResponse

    @GET("movie/{movie_id}")
    suspend fun getMovie(@Path("movie_id") id: Int): Movie

    @GET("movie/{movie_id}/credits")
    suspend fun getCredits(@Path("movie_id") id: Int): CreditResponse
}