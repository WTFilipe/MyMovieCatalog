package com.filipeoliveira.domain.usecase

import com.filipeoliveira.domain.model.Movie

interface MarkMovieAsWatchedUseCase {
    suspend fun execute(movie: Movie)
}