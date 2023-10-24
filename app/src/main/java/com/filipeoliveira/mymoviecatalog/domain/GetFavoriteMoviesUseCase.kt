package com.filipeoliveira.mymoviecatalog.domain

import com.filipeoliveira.mymoviecatalog.data.Movie
import kotlinx.coroutines.flow.Flow

interface GetFavoriteMoviesUseCase {
    suspend fun execute() : Flow<Result<List<Movie>>>
}