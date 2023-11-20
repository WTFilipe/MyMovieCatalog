package com.filipeoliveira.data

import androidx.paging.PagingData
import com.filipeoliveira.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeMovieRepository : MovieRepository {

    private var movieList = mutableListOf<Movie>()

    fun addMovieList(list: List<Movie>){
        movieList = list.toMutableList()
    }

    override suspend fun getPopularMovies(): Flow<PagingData<Movie>> = flow {
        emit(PagingData.from(movieList))
    }

    suspend fun getPopularMoviesWithoutPaging() : Flow<List<Movie>> = flow {
        emit(movieList)
    }

    override suspend fun searchMovies(query: String): Flow<PagingData<Movie>> = flow {
        val filterList = movieList.filter { it.title.contains(query) || it.original_title.contains(query) || it.overview.contains(query) }
        emit(PagingData.from(filterList))
    }

    suspend fun searchMoviesWithoutPaging(query: String): Flow<List<Movie>> = flow {
        val filterList = movieList.filter { it.title.contains(query) || it.original_title.contains(query) || it.overview.contains(query) }
        emit(filterList)
    }

    override suspend fun getFavoriteMovies(): Flow<List<Movie>> = flow {
        val favoriteMovie = movieList.filter { it.isFavorite }
        emit(favoriteMovie)
    }

    override suspend fun markMovieAsWatched(movie: Movie) {
        val foundMovie = movieList.find { it.id == movie.id}
        foundMovie?.let {
            movieList.remove(foundMovie)
            movieList.add(foundMovie.copy(isWatched = true))
        }
    }

    override suspend fun markMovieAsNotWatched(movie: Movie) {
        val foundMovie = movieList.find { it.id == movie.id }
        foundMovie?.let {
            movieList.remove(foundMovie)
            movieList.add(foundMovie.copy(isWatched = false))
        }
    }

    override suspend fun addToFavorites(movie: Movie) {
        val foundMovie = movieList.find { it.id == movie.id }
        foundMovie?.let {
            movieList.remove(foundMovie)
            movieList.add(foundMovie.copy(isFavorite = true))
        }
    }

    override suspend fun removeFromFavorites(movie: Movie) {
        val foundMovie = movieList.find { it.id == movie.id }
        foundMovie?.let {
            movieList.remove(foundMovie)
            movieList.add(foundMovie.copy(isFavorite = false))
        }
    }

    override suspend fun isFavorite(movie: Movie): Flow<Boolean> = flow {
        val isMovieFavorite = movieList.firstOrNull { it.id == movie.id }?.isFavorite ?: false
        emit(isMovieFavorite)
    }

    override suspend fun isWatched(movie: Movie): Flow<Boolean> = flow {
        val isMovieWatched = movieList.firstOrNull { it.id == movie.id }?.isWatched ?: false
        emit(isMovieWatched)
    }
}