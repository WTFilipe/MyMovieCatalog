package com.filipeoliveira.data.usecase

import com.filipeoliveira.data.MovieRepository
import com.filipeoliveira.domain.model.Movie
import com.filipeoliveira.domain.usecase.IsFavoriteUseCase
import javax.inject.Inject

class IsFavoriteUseCaseImpl @Inject constructor(
    private val repository: MovieRepository
) : IsFavoriteUseCase {
    override suspend fun execute(movie: Movie) = repository.isFavorite(movie = movie)
}