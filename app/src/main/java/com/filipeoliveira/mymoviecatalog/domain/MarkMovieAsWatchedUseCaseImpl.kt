package com.filipeoliveira.mymoviecatalog.domain

import com.filipeoliveira.mymoviecatalog.data.Movie
import com.filipeoliveira.mymoviecatalog.data.MovieRepository
import javax.inject.Inject

class MarkMovieAsWatchedUseCaseImpl @Inject constructor(
    private val repository: MovieRepository
) : MarkMovieAsWatchedUseCase {
    override suspend fun execute(movie: Movie) = repository.markMovieAsWatched(movie = movie)
}