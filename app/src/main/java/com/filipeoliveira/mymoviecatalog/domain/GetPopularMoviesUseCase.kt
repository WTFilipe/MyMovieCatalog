package com.filipeoliveira.mymoviecatalog.domain

import com.filipeoliveira.mymoviecatalog.data.Movie
import kotlinx.coroutines.flow.Flow

interface GetPopularMoviesUseCase {
    suspend fun execute(page: Int) : Flow<Result<List<Movie>>>
}