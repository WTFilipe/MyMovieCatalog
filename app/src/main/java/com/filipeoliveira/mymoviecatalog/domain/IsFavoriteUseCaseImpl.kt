package com.filipeoliveira.mymoviecatalog.domain

import com.filipeoliveira.mymoviecatalog.data.Movie
import com.filipeoliveira.mymoviecatalog.data.MovieRepository
import javax.inject.Inject

class IsFavoriteUseCaseImpl @Inject constructor(
    private val repository: MovieRepository
) : IsFavoriteUseCase {
    override suspend fun execute(movie: Movie) = repository.isFavorite(movie = movie)
}