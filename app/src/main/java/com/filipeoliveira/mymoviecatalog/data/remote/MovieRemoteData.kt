package com.filipeoliveira.mymoviecatalog.data.remote

import com.filipeoliveira.mymoviecatalog.data.remote.model.MovieRemote

interface MovieRemoteData {

    suspend fun getPopularMovies(page: Int = 1) : List<MovieRemote>
}