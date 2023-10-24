package com.filipeoliveira.mymoviecatalog.domain

import com.filipeoliveira.mymoviecatalog.data.Movie
import com.filipeoliveira.mymoviecatalog.data.MovieRepository
import com.filipeoliveira.mymoviecatalog.domain.error.EmptyResponseError
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetFavoriteMoviesUseCaseImpl @Inject constructor(
    private val repository: MovieRepository
) : GetFavoriteMoviesUseCase {
    override suspend fun execute(): Flow<Result<List<Movie>>> = flow {
        repository.getFavoriteMovies()
            .catch {
                emit(Result.Error(it))
            }
            .collect {
                if (it.isEmpty()) {
                    emit(Result.Error(EmptyResponseError()))
                } else {
                    emit(Result.Success(it))
                }
            }
    }
}