package com.filipeoliveira.mymoviecatalog.data.local

import com.filipeoliveira.mymoviecatalog.data.local.model.MovieDB
import kotlinx.coroutines.flow.Flow

interface MovieLocalData {

    suspend fun getFavoriteMoviesList() : Flow<List<MovieDB>>
    suspend fun markMovieAsWatched(movieId: Int)
    suspend fun markMovieAsNotWatched(movieId: Int)
}