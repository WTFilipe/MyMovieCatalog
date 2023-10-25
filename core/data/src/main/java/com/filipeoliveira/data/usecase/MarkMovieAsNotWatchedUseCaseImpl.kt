package com.filipeoliveira.data.usecase

import com.filipeoliveira.data.MovieRepository
import com.filipeoliveira.domain.model.Movie
import com.filipeoliveira.domain.usecase.MarkMovieAsNotWatchedUseCase
import javax.inject.Inject

class MarkMovieAsNotWatchedUseCaseImpl @Inject constructor(
    private val repository: MovieRepository
) : MarkMovieAsNotWatchedUseCase {
    override suspend fun execute(movie: Movie) = repository.markMovieAsNotWatched(movie = movie)
}