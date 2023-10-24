package com.filipeoliveira.mymoviecatalog.data.local

import javax.inject.Inject

class MovieLocalDataImpl @Inject constructor(
    private val appDatabase: AppDatabase
) : MovieLocalData {
    override suspend fun getFavoriteMoviesList() = appDatabase.getMoviesDAO().getFavoriteMovies()

    override suspend fun markMovieAsWatched(movieId: Int) {
        appDatabase.getMoviesDAO().markMovieAsWatched(movieId = movieId)
    }

    override suspend fun markMovieAsNotWatched(movieId: Int) {
        appDatabase.getMoviesDAO().markMovieAsNotWatched(movieId = movieId)
    }

}