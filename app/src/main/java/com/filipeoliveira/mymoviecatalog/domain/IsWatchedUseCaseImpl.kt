package com.filipeoliveira.mymoviecatalog.domain

import com.filipeoliveira.mymoviecatalog.data.Movie
import com.filipeoliveira.mymoviecatalog.data.MovieRepository
import javax.inject.Inject

class IsWatchedUseCaseImpl @Inject constructor(
    private val repository: MovieRepository
) : IsWatchedUseCase {
    override suspend fun execute(movie: Movie) = repository.isWatched(movie = movie)
}