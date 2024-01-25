package com.olegatron.themoviedb.ui.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.olegatron.domain.model.Credit
import com.olegatron.themoviedb.databinding.ListCreditBinding
import com.olegatron.themoviedb.ui.views.viewholders.ActorsViewHolder

class CreditAdapter(private val actors: List<Credit>) : RecyclerView.Adapter<ActorsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorsViewHolder {
        val binding = ListCreditBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ActorsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ActorsViewHolder, position: Int) {
        val actor = actors[position]
        holder.bind(actor)
    }

    override fun getItemCount(): Int {
        return actors.size
    }
}