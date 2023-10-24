package com.filipeoliveira.mymoviecatalog.data.remote

import com.filipeoliveira.mymoviecatalog.data.remote.model.MovieRemoteResponse

interface MovieRemoteData {
    suspend fun getPopularMovies(page: Int = 1) : MovieRemoteResponse
}