package com.olegatron.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.olegatron.domain.model.Movie
import com.olegatron.domain.usecases.GetMoviesUseCase

class MoviePagingSource(
    private val getMoviesUseCase: GetMoviesUseCase,
) : PagingSource<Int, Movie>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val currentPage = params.key ?: 1
            val response = getMoviesUseCase.invoke(currentPage)

            LoadResult.Page(
                data = response,
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = if (response.isEmpty()) null else currentPage + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return null
    }
}
