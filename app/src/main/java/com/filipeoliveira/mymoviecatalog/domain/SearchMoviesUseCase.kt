package com.filipeoliveira.mymoviecatalog.domain

import androidx.paging.PagingData
import com.filipeoliveira.mymoviecatalog.data.Movie
import kotlinx.coroutines.flow.Flow

interface SearchMoviesUseCase {
    suspend fun execute(query: String) : Flow<PagingData<Movie>>
}