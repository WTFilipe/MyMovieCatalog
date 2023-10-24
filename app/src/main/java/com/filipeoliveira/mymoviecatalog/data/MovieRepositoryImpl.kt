package com.filipeoliveira.mymoviecatalog.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.filipeoliveira.mymoviecatalog.data.remote.MoviePagingSource
import com.filipeoliveira.mymoviecatalog.data.remote.MovieRemoteData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor (
    private val remoteData: MovieRemoteData
) : MovieRepository {
    override suspend fun getPopularMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(pageSize = PAGE_SIZE, prefetchDistance = PREFETCH_DISTANCE),
            pagingSourceFactory = {
                MoviePagingSource(remoteData)
            }
        ).flow
    }

    companion object {
        const val PAGE_SIZE = 20
        const val PREFETCH_DISTANCE = 2
    }
}