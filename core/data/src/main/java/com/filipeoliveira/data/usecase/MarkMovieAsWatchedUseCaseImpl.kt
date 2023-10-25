package com.filipeoliveira.data.usecase

import com.filipeoliveira.data.MovieRepository
import com.filipeoliveira.domain.model.Movie
import com.filipeoliveira.domain.usecase.MarkMovieAsWatchedUseCase
import javax.inject.Inject

class MarkMovieAsWatchedUseCaseImpl @Inject constructor(
    private val repository: MovieRepository
) : MarkMovieAsWatchedUseCase {
    override suspend fun execute(movie: Movie) = repository.markMovieAsWatched(movie = movie)
}