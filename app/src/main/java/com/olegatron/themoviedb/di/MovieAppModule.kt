package com.olegatron.themoviedb.di

import com.olegatron.domain.usecases.GetCreditsUseCase
import com.olegatron.domain.usecases.GetMovieUseCase
import com.olegatron.domain.usecases.GetMoviesUseCase
import com.olegatron.themoviedb.ui.screens.details.DetailsViewModel
import com.olegatron.themoviedb.ui.screens.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val movieAppModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailsViewModel(get(), get()) }

    single { GetMoviesUseCase(get()) }
    single { GetMovieUseCase(get()) }
    single { GetCreditsUseCase(get()) }
}