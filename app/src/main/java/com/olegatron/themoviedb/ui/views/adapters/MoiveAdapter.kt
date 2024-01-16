package com.olegatron.themoviedb.ui.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.olegatron.domain.model.Movie
import com.olegatron.themoviedb.databinding.ListItemBinding
import com.olegatron.themoviedb.ui.views.utils.MovieDiffCallback
import com.olegatron.themoviedb.ui.views.viewholders.MovieViewHolder

class MovieAdapter : ListAdapter<Movie, MovieViewHolder>(
    MovieDiffCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
    }
}