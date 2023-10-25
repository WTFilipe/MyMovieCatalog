package com.filipeoliveira.mymoviecatalog.domain

import com.filipeoliveira.mymoviecatalog.data.Movie
import com.filipeoliveira.mymoviecatalog.data.MovieRepository
import javax.inject.Inject

class RemoveFromFavoriteUseCaseImpl @Inject constructor(
    private val repository: MovieRepository
) : RemoveFromFavoriteUseCase {
    override suspend fun execute(movie: Movie) = repository.removeFromFavorites(movie = movie)
}