package com.olegatron.themoviedb.ui.views.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.olegatron.domain.model.Movie
import com.olegatron.themoviedb.R
import com.olegatron.themoviedb.databinding.ListItemBinding

private const val URL = "https://image.tmdb.org/t/p/w500"

class MovieViewHolder(private val binding: ListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie) {
        binding.apply {
            tvMovieTitle.text = movie.title

            Glide.with(itemView)
                .load(URL + movie.poster)
                .thumbnail(Glide.with(itemView).load(R.drawable.cat))
                .into(ivPoster)
        }
    }
}