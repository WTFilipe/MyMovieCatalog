package com.filipeoliveira.data.usecase

import com.filipeoliveira.data.MovieRepository
import com.filipeoliveira.domain.model.Movie
import com.filipeoliveira.domain.usecase.RemoveFromFavoriteUseCase
import javax.inject.Inject

class RemoveFromFavoriteUseCaseImpl @Inject constructor(
    private val repository: MovieRepository
) : RemoveFromFavoriteUseCase {
    override suspend fun execute(movie: Movie) = repository.removeFromFavorites(movie = movie)
}