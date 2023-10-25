package com.filipeoliveira.data.usecase

import androidx.paging.PagingData
import com.filipeoliveira.data.MovieRepository
import com.filipeoliveira.domain.model.Movie
import com.filipeoliveira.domain.usecase.GetPopularMoviesUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPopularMoviesUseCaseImpl @Inject constructor(
    private val repository: MovieRepository
) : GetPopularMoviesUseCase {
    override suspend fun execute(): Flow<PagingData<Movie>> = repository.getPopularMovies()
}