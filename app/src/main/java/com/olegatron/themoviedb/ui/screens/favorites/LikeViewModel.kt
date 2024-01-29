package com.olegatron.themoviedb.ui.screens.favorites

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olegatron.domain.db.usecases.GetLikesUseCase
import com.olegatron.domain.model.Movie
import com.olegatron.domain.usecases.GetMovieUseCase
import kotlinx.coroutines.launch

class LikeViewModel(
    private val getLikesUseCase: GetLikesUseCase,
    private val getMovieUseCase: GetMovieUseCase
) : ViewModel() {
    var favoritesList = MutableLiveData<List<Movie>>()
    private val currentList = favoritesList.value?.toMutableList() ?: mutableListOf()

    init {
        getLikes()
    }

    private fun getLikes() {
        viewModelScope.launch {
            getLikesUseCase().forEach {
                currentList.add(getMovieUseCase(it.movieId!!))
                favoritesList.value = currentList
            }
        }
    }
}