package com.olegatron.themoviedb.ui.views.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.olegatron.domain.model.Credit
import com.olegatron.domain.model.Movie
import com.olegatron.themoviedb.R
import com.olegatron.themoviedb.databinding.ListCreditBinding
import com.olegatron.themoviedb.databinding.ListItemBinding

class ActorsViewHolder(private val binding: ListCreditBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(actor: Credit) {
        binding.apply {
            tvActorName.text = actor.name
            tvActorRole.text = actor.character

            Glide.with(itemView)
                .load("https://image.tmdb.org/t/p/w500" + actor.profilePath)
                .thumbnail(Glide.with(itemView).load(R.drawable.cat))
                .into(ivActorPhoto)
        }
    }
}