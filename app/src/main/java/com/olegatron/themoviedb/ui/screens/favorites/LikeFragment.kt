package com.olegatron.themoviedb.ui.screens.favorites

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.olegatron.themoviedb.databinding.FragmentLikeBinding
import com.olegatron.themoviedb.ui.views.adapters.FavoritesAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class LikeFragment : Fragment() {
    private val viewModel by viewModel<LikeViewModel>()
    private var _binding: FragmentLikeBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: FavoritesAdapter
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLikeBinding.inflate(layoutInflater)

        adapter = FavoritesAdapter(listOf(), findNavController())

        binding.apply {
            recyclerView = rvFavoritesList

            lifecycleScope.launch {
                viewModel.favoritesList.observe(viewLifecycleOwner) {
                    adapter.updateList(it)
                }
            }
        }

        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView.adapter = adapter

        return binding.root
    }
}