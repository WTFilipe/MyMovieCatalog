package com.filipeoliveira.mymoviecatalog.domain

import com.filipeoliveira.mymoviecatalog.data.Movie
import kotlinx.coroutines.flow.Flow

interface IsWatchedUseCase {
    suspend fun execute(movie: Movie): Flow<Boolean>
}