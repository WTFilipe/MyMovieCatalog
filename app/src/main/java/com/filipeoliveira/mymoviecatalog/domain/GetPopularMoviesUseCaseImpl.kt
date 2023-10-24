package com.filipeoliveira.mymoviecatalog.domain

import androidx.paging.PagingData
import com.filipeoliveira.mymoviecatalog.data.Movie
import com.filipeoliveira.mymoviecatalog.data.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPopularMoviesUseCaseImpl @Inject constructor(
    private val repository: MovieRepository
) : GetPopularMoviesUseCase {
    override suspend fun execute(): Flow<PagingData<Movie>> = repository.getPopularMovies()
}