package com.filipeoliveira.mymoviecatalog.data.remote

import com.filipeoliveira.mymoviecatalog.data.remote.model.MovieRemoteResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("page") page: Int): MovieRemoteResponse
}