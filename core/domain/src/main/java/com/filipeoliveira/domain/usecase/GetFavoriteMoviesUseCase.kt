package com.filipeoliveira.domain.usecase

import com.filipeoliveira.domain.model.Movie
import com.filipeoliveira.domain.Result
import kotlinx.coroutines.flow.Flow

interface GetFavoriteMoviesUseCase {
    suspend fun execute() : Flow<Result<List<Movie>>>
}