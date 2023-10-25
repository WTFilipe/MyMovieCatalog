package com.filipeoliveira.domain.usecase

import androidx.paging.PagingData
import com.filipeoliveira.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface GetPopularMoviesUseCase {
    suspend fun execute() : Flow<PagingData<Movie>>
}