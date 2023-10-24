package com.filipeoliveira.mymoviecatalog.domain

import androidx.paging.PagingData
import com.filipeoliveira.mymoviecatalog.data.Movie
import kotlinx.coroutines.flow.Flow

interface GetPopularMoviesUseCase {
    suspend fun execute() : Flow<PagingData<Movie>>
}