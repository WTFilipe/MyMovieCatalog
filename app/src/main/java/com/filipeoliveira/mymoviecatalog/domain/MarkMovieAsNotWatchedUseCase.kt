package com.filipeoliveira.mymoviecatalog.domain

import com.filipeoliveira.mymoviecatalog.data.Movie

interface MarkMovieAsNotWatchedUseCase {
    suspend fun execute(movie: Movie)
}