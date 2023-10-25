package com.filipeoliveira.domain.usecase

import com.filipeoliveira.domain.model.Movie


interface AddToFavoriteUseCase {
    suspend fun execute(movie: Movie)
}