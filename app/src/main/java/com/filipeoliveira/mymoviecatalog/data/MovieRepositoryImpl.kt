package com.filipeoliveira.mymoviecatalog.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.filipeoliveira.mymoviecatalog.data.local.MovieLocalData
import com.filipeoliveira.mymoviecatalog.data.mapper.toMovie
import com.filipeoliveira.mymoviecatalog.data.remote.MoviePagingSource
import com.filipeoliveira.mymoviecatalog.data.remote.MovieRemoteData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor (
    private val remoteData: MovieRemoteData,
    private val localData: MovieLocalData
) : MovieRepository {
    override suspend fun getPopularMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(pageSize = PAGE_SIZE, prefetchDistance = PREFETCH_DISTANCE),
            pagingSourceFactory = {
                MoviePagingSource(remoteData)
            }
        ).flow
    }

    override suspend fun getFavoriteMovies(): Flow<List<Movie>> = localData.getFavoriteMoviesList().map { list ->
        list.map {
            it.toMovie()
        }
    }

    override suspend fun toggleMovieWatchedFlag(movie: Movie) {
        if (movie.isWatched){
            localData.markMovieAsNotWatched(movieId = movie.id)
        } else {
            localData.markMovieAsWatched(movieId = movie.id)
        }
    }

    companion object {
        const val PAGE_SIZE = 20
        const val PREFETCH_DISTANCE = 2
    }
}