package com.olegatron.themoviedb.ui.views.utils

import androidx.recyclerview.widget.DiffUtil
import com.olegatron.domain.model.Movie

class MovieDiffCallback : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }
}