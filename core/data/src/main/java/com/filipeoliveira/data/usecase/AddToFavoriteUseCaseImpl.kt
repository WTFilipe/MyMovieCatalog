package com.filipeoliveira.data.usecase

import com.filipeoliveira.data.MovieRepository
import com.filipeoliveira.domain.model.Movie
import com.filipeoliveira.domain.usecase.AddToFavoriteUseCase
import javax.inject.Inject

class AddToFavoriteUseCaseImpl @Inject constructor(
    private val repository: MovieRepository
) : AddToFavoriteUseCase {
    override suspend fun execute(movie: Movie) = repository.addToFavorites(movie = movie)
}