package com.olegatron.themoviedb.ui.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.paging.PagingDataAdapter
import com.olegatron.domain.model.Movie
import com.olegatron.themoviedb.databinding.ListItemBinding
import com.olegatron.themoviedb.ui.screens.home.HomeFragmentDirections
import com.olegatron.themoviedb.ui.views.utils.MovieDiffCallback
import com.olegatron.themoviedb.ui.views.viewholders.MovieViewHolder

class MovieAdapter(private val navController: NavController) : PagingDataAdapter<Movie, MovieViewHolder>(
    MovieDiffCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie!!)

        holder.itemView.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(movie.id!!)
            navController.navigate(action)
        }
    }
}