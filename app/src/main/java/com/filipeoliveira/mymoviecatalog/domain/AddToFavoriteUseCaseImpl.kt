package com.filipeoliveira.mymoviecatalog.domain

import com.filipeoliveira.mymoviecatalog.data.Movie
import com.filipeoliveira.mymoviecatalog.data.MovieRepository
import javax.inject.Inject

class AddToFavoriteUseCaseImpl @Inject constructor(
    private val repository: MovieRepository
) : AddToFavoriteUseCase {
    override suspend fun execute(movie: Movie) = repository.addToFavorites(movie = movie)
}