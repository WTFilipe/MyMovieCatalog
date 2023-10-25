package com.filipeoliveira.data.usecase

import androidx.paging.LoadState
import androidx.paging.LoadStates
import androidx.paging.PagingData
import com.filipeoliveira.data.MovieRepository
import com.filipeoliveira.domain.error.ShortInputError
import com.filipeoliveira.domain.model.Movie
import com.filipeoliveira.domain.usecase.SearchMoviesUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchMoviesUseCaseImpl @Inject constructor(
    private val repository: MovieRepository
) : SearchMoviesUseCase {
    override suspend fun execute(query: String): Flow<PagingData<Movie>> = flow {
        if (query.length < 3){
            val pagingData = PagingData.empty<Movie>(LoadStates(
                refresh = LoadState.Error(ShortInputError()),
                prepend = LoadState.Error(ShortInputError()),
                append = LoadState.Error(ShortInputError())
            ))
            emit(pagingData)
        } else {
            repository.searchMovies(query).collect{
                emit(it)
            }
        }
    }
}