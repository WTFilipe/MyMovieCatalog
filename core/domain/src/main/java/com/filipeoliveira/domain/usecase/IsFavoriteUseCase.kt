package com.filipeoliveira.domain.usecase

import com.filipeoliveira.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface IsFavoriteUseCase {
    suspend fun execute(movie: Movie): Flow<Boolean>
}