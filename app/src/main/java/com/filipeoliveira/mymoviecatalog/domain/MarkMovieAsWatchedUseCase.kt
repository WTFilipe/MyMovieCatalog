package com.filipeoliveira.mymoviecatalog.domain

import com.filipeoliveira.mymoviecatalog.data.Movie

interface MarkMovieAsWatchedUseCase {
    suspend fun execute(movie: Movie)
}