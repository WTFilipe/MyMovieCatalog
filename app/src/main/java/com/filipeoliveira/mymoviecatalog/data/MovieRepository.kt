package com.filipeoliveira.mymoviecatalog.data

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getPopularMovies() : Flow<PagingData<Movie>>
    suspend fun getFavoriteMovies() : Flow<List<Movie>>
    suspend fun toggleMovieWatchedFlag(movie: Movie)
}