package com.olegatron.themoviedb.ui.screens.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.like.LikeButton
import com.like.OnLikeListener
import com.olegatron.data.db.data.Like
import com.olegatron.themoviedb.databinding.FragmentDetailsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsFragment : Fragment() {
    private val viewModel by viewModel<DetailsViewModel>()

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    private val id by navArgs<DetailsFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(layoutInflater)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.getMovie(id.movieId)
        viewModel.getCredits(id.movieId)
        viewModel.isLiked(id.movieId)

        binding.button.setOnLikeListener(object: OnLikeListener {
            override fun liked(likeButton: LikeButton?) {
                viewModel.insertLike(Like(id.movieId))
            }

            override fun unLiked(likeButton: LikeButton?) {
                viewModel.removeLike(id.movieId)
            }
        })

        return binding.root
    }
}