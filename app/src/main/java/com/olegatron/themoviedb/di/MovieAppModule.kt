package com.olegatron.themoviedb.di

import com.olegatron.domain.usecases.GetMoviesUseCase
import com.olegatron.themoviedb.ui.screens.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val movieAppModule = module {
    viewModel { HomeViewModel(get()) }

    single { GetMoviesUseCase(get()) }
}