package com.filipeoliveira.mymoviecatalog.domain

import com.filipeoliveira.mymoviecatalog.data.Movie
import com.filipeoliveira.mymoviecatalog.data.MovieRepository
import javax.inject.Inject

class MarkMovieAsNotWatchedUseCaseImpl @Inject constructor(
    private val repository: MovieRepository
) : MarkMovieAsNotWatchedUseCase {
    override suspend fun execute(movie: Movie) = repository.markMovieAsNotWatched(movie = movie)
}