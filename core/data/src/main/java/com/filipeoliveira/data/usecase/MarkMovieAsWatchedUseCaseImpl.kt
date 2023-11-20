package com.filipeoliveira.data.usecase

import com.filipeoliveira.data.MovieRepository
import com.filipeoliveira.domain.error.InvalidMovieIdError
import com.filipeoliveira.domain.model.Movie
import com.filipeoliveira.domain.usecase.MarkMovieAsWatchedUseCase
import javax.inject.Inject

class MarkMovieAsWatchedUseCaseImpl @Inject constructor(
    private val repository: MovieRepository
) : MarkMovieAsWatchedUseCase {
    override suspend fun execute(movie: Movie) {
        if (movie.id >= 0) {
            repository.markMovieAsWatched(movie = movie)
        } else {
            throw InvalidMovieIdError()
        }
    }
}