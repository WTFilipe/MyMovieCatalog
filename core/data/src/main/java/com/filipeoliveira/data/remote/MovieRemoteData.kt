package com.filipeoliveira.data.remote

import com.filipeoliveira.data.remote.model.MovieRemoteResponse

interface MovieRemoteData {
    suspend fun getPopularMovies(page: Int = 1) : MovieRemoteResponse
    suspend fun searchMovies(page: Int = 1, query: String) : MovieRemoteResponse
}