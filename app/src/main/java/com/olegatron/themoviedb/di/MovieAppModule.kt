package com.olegatron.themoviedb.di

import com.olegatron.domain.db.usecases.GetLikeUseCase
import com.olegatron.domain.db.usecases.GetLikesUseCase
import com.olegatron.domain.db.usecases.InsertLikeUseCase
import com.olegatron.domain.db.usecases.RemoveLikeUseCase
import com.olegatron.domain.usecases.GetCreditsUseCase
import com.olegatron.domain.usecases.GetMovieUseCase
import com.olegatron.domain.usecases.GetMoviesUseCase
import com.olegatron.themoviedb.ui.screens.details.DetailsViewModel
import com.olegatron.themoviedb.ui.screens.favorites.LikeViewModel
import com.olegatron.themoviedb.ui.screens.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val movieAppModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailsViewModel(get(), get(), get(), get()) }
    viewModel { LikeViewModel(get(), get()) }

    single { GetMoviesUseCase(get()) }
    single { GetMovieUseCase(get()) }
    single { GetCreditsUseCase(get()) }

    single { GetLikesUseCase(get()) }
    single { GetLikeUseCase(get()) }
    single { InsertLikeUseCase(get()) }
    single { RemoveLikeUseCase(get()) }
}