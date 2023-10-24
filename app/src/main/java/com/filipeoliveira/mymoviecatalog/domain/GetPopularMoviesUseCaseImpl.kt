package com.filipeoliveira.mymoviecatalog.domain

import com.filipeoliveira.mymoviecatalog.data.Movie
import com.filipeoliveira.mymoviecatalog.data.MovieRepository
import com.filipeoliveira.mymoviecatalog.domain.error.EmptyResponseError
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPopularMoviesUseCaseImpl @Inject constructor(
    private val repository: MovieRepository
) : GetPopularMoviesUseCase {
    override suspend fun execute(page: Int): Flow<Result<List<Movie>>> = flow {
        repository.getPopularMovies(page)
            .catch {
                emit(Result.Error(it))
            }
            .collect { list ->
                if (list.isEmpty()) {
                    emit(Result.Error(EmptyResponseError()))
                } else {
                    emit(Result.Success(list))
                }
            }
    }
}