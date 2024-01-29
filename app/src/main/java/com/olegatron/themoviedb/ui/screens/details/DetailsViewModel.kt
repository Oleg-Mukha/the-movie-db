package com.olegatron.themoviedb.ui.screens.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olegatron.data.db.data.Like
import com.olegatron.domain.db.usecases.InsertLikeUseCase
import com.olegatron.domain.db.usecases.RemoveLikeUseCase
import com.olegatron.domain.model.Credit
import com.olegatron.domain.model.Movie
import com.olegatron.domain.usecases.GetCreditsUseCase
import com.olegatron.domain.usecases.GetMovieUseCase
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val getMovieUseCase: GetMovieUseCase,
    private val getCreditsUseCase: GetCreditsUseCase,
    private val insertLikeUseCase: InsertLikeUseCase,
    private val removeLikeUseCase: RemoveLikeUseCase
) : ViewModel() {
    private var _movie = MutableLiveData<Movie>()
    val movie: LiveData<Movie> = _movie

    private var _credits = MutableLiveData<List<Credit>>()
    val credits: LiveData<List<Credit>> = _credits

    val isLikedItem = MutableLiveData<Boolean>()

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

    fun isLiked(movieId: Int) {
        viewModelScope.launch {
            isLikedItem.value = getMovieUseCase(movieId) != null
        }
    }

    fun insertLike(like: Like) {
        viewModelScope.launch {
            insertLikeUseCase(like.convert())
        }
    }

    fun removeLike(movieId: Int) {
        viewModelScope.launch {
            removeLikeUseCase(movieId)
        }
    }
}