package com.filipeoliveira.mymoviecatalog.domain

import androidx.paging.PagingData
import com.filipeoliveira.mymoviecatalog.data.Movie
import com.filipeoliveira.mymoviecatalog.data.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchMoviesUseCaseImpl @Inject constructor(
    private val repository: MovieRepository
) : SearchMoviesUseCase {
    override suspend fun execute(query: String): Flow<PagingData<Movie>> = repository.searchMovies(query)
}