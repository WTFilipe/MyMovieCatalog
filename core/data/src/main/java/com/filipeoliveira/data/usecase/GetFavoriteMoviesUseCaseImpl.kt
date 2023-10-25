package com.filipeoliveira.data.usecase

import com.filipeoliveira.data.MovieRepository
import com.filipeoliveira.domain.error.EmptyResponseError
import com.filipeoliveira.domain.model.Movie
import com.filipeoliveira.domain.usecase.GetFavoriteMoviesUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import com.filipeoliveira.domain.Result

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