package com.filipeoliveira.domain.usecase

import com.filipeoliveira.domain.model.Movie

interface RemoveFromFavoriteUseCase {
    suspend fun execute(movie: Movie)
}