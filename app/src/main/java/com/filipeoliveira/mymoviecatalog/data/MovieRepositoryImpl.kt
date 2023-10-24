package com.filipeoliveira.mymoviecatalog.data

import com.filipeoliveira.mymoviecatalog.data.mapper.toMovie
import com.filipeoliveira.mymoviecatalog.data.remote.MovieRemoteData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor (
    private val remoteData: MovieRemoteData
) : MovieRepository {
    override suspend fun getPopularMovies(page: Int): Flow<List<Movie>> = flow {
        val movieList = remoteData.getPopularMovies().map {
            it.toMovie()
        }
        emit(movieList)
    }
}