package com.olegatron.themoviedb.ui.views.bindingadapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("setImage")
fun setImage(imageView: ImageView, image: String?) {
    Glide.with(imageView.context)
        .load("https://image.tmdb.org/t/p/w500$image")
        .into(imageView)
}