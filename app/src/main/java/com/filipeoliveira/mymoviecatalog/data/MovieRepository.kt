package com.filipeoliveira.mymoviecatalog.data

import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    suspend fun getPopularMovies(page: Int) : Flow<List<Movie>>
}