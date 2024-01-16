package com.olegatron.themoviedb.ui.screens.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olegatron.domain.model.Movie

import com.olegatron.domain.usecases.GetMoviesUseCase
import kotlinx.coroutines.launch

class HomeViewModel(private val getMoviesUseCase: GetMoviesUseCase) : ViewModel() {
    private var _movies = MutableLiveData<List<Movie>?>()
    val movies: LiveData<List<Movie>?> = _movies

    init {
        getTrendingMovies()
    }

    private fun getTrendingMovies() {
        viewModelScope.launch {
            val response = getMoviesUseCase()
            _movies.postValue(response)
        }
    }
}