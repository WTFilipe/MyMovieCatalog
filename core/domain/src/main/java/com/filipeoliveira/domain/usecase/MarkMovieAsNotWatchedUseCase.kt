package com.filipeoliveira.domain.usecase

import com.filipeoliveira.domain.model.Movie

interface MarkMovieAsNotWatchedUseCase {
    suspend fun execute(movie: Movie)
}