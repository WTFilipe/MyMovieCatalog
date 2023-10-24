package com.filipeoliveira.mymoviecatalog.data.remote

import com.filipeoliveira.mymoviecatalog.data.remote.model.MovieRemote
import javax.inject.Inject

class MovieRemoteDataImpl @Inject constructor (
    private val service: MovieService
) : MovieRemoteData {
    override suspend fun getPopularMovies(page: Int): List<MovieRemote> {
        return service.getPopularMovies().results
    }
}