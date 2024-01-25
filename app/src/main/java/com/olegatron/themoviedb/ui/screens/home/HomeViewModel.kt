package com.olegatron.themoviedb.ui.screens.home


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.olegatron.data.paging.MoviePagingSource
import com.olegatron.domain.usecases.GetMoviesUseCase

class HomeViewModel(private val getMoviesUseCase: GetMoviesUseCase) : ViewModel() {
    val movies = Pager(
        config = PagingConfig(
            pageSize = 20,
            enablePlaceholders = false
        ),
        pagingSourceFactory = { MoviePagingSource(getMoviesUseCase) })
        .flow.cachedIn(viewModelScope)
}