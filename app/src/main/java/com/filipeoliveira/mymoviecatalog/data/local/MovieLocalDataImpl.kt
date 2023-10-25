package com.filipeoliveira.mymoviecatalog.data.local

import com.filipeoliveira.mymoviecatalog.data.local.model.MovieDB
import kotlinx.coroutines.flow.Flow
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

    override suspend fun addToFavorites(movie: MovieDB) {
        appDatabase.getMoviesDAO().addMovie(movie = movie)
    }

    override suspend fun removeFromFavorites(movie: MovieDB) {
        appDatabase.getMoviesDAO().deleteMovie(movie = movie)
    }
    override suspend fun isFavorite(movie: MovieDB): Flow<Boolean> = appDatabase.getMoviesDAO().isFavorite(movieId = movie.id)
    override suspend fun isWatched(movie: MovieDB): Flow<Int> = appDatabase.getMoviesDAO().isWatched(movieId = movie.id)

}