package com.filipeoliveira.data.usecase

import com.filipeoliveira.data.MovieRepository
import com.filipeoliveira.domain.model.Movie
import com.filipeoliveira.domain.usecase.IsWatchedUseCase
import javax.inject.Inject

class IsWatchedUseCaseImpl @Inject constructor(
    private val repository: MovieRepository
) : IsWatchedUseCase {
    override suspend fun execute(movie: Movie) = repository.isWatched(movie = movie)
}