package com.olegatron.themoviedb.ui.screens.details

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olegatron.domain.model.Credit
import com.olegatron.domain.model.Movie
import com.olegatron.domain.usecases.GetCreditsUseCase
import com.olegatron.domain.usecases.GetMovieUseCase
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val getMovieUseCase: GetMovieUseCase,
    private val getCreditsUseCase: GetCreditsUseCase
) : ViewModel() {
    private var _movie = MutableLiveData<Movie>()
    val movie: LiveData<Movie> = _movie

    private var _credits = MutableLiveData<List<Credit>>()
    val credits: LiveData<List<Credit>> = _credits

    fun getMovie(movieId: Int) {
        viewModelScope.launch {
            _movie.value = getMovieUseCase(movieId)
        }
    }

    fun getCredits(movieId: Int) {
        viewModelScope.launch {
            _credits.value = getCreditsUseCase(movieId)
        }
    }
}