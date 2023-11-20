package com.filipeoliveira.data.usecase

import com.filipeoliveira.data.MovieRepository
import com.filipeoliveira.domain.error.InvalidMovieIdError
import com.filipeoliveira.domain.model.Movie
import com.filipeoliveira.domain.usecase.MarkMovieAsNotWatchedUseCase
import javax.inject.Inject

class MarkMovieAsNotWatchedUseCaseImpl @Inject constructor(
    private val repository: MovieRepository
) : MarkMovieAsNotWatchedUseCase {
    override suspend fun execute(movie: Movie) {
        if (movie.id >= 0){
            repository.markMovieAsNotWatched(movie = movie)
        } else {
            throw InvalidMovieIdError()
        }
    }
}