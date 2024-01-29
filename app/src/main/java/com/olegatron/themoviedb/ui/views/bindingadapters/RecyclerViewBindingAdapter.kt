package com.olegatron.themoviedb.ui.views.bindingadapters

import android.util.Log
import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.olegatron.domain.model.Credit
import com.olegatron.themoviedb.ui.views.adapters.CreditAdapter

@BindingAdapter("observeList")
fun RecyclerView.observeList(list: List<Credit>?) {
    this.layoutManager =
        LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
    this.adapter = CreditAdapter(list ?: emptyList())
}