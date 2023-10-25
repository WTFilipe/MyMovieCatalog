package com.filipeoliveira.domain.usecase

import com.filipeoliveira.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface IsWatchedUseCase {
    suspend fun execute(movie: Movie): Flow<Boolean>
}