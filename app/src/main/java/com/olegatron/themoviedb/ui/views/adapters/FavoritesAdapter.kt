package com.olegatron.themoviedb.ui.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.olegatron.domain.model.Movie
import com.olegatron.themoviedb.databinding.ListItemBinding
import com.olegatron.themoviedb.ui.screens.favorites.LikeFragmentDirections
import com.olegatron.themoviedb.ui.views.viewholders.MovieViewHolder

class FavoritesAdapter(private var favList: List<Movie>, private val navController: NavController) :
    RecyclerView.Adapter<MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = favList[position]
        holder.bind(movie)

        holder.itemView.setOnClickListener {
            val action = LikeFragmentDirections.actionLikeFragmentToDetailsFragment(movie.id!!)
            navController.navigate(action)
        }
    }

    override fun getItemCount(): Int = favList.size

    fun updateList(updatedList: List<Movie>){
        favList = updatedList
        notifyDataSetChanged()
    }
}