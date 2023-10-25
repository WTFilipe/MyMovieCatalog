package com.filipeoliveira.domain.usecase

import androidx.paging.PagingData
import com.filipeoliveira.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface SearchMoviesUseCase {
    suspend fun execute(query: String) : Flow<PagingData<Movie>>
}