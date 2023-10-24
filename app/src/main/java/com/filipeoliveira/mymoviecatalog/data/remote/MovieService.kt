package com.filipeoliveira.mymoviecatalog.data.remote

import com.filipeoliveira.mymoviecatalog.data.remote.model.MovieRemoteResponse
import retrofit2.http.GET

interface MovieService {

    @GET("movie/popular")
    suspend fun getPopularMovies(): MovieRemoteResponse
}