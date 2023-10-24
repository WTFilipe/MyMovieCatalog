package com.filipeoliveira.mymoviecatalog.data.local

import androidx.room.Dao
import androidx.room.Query
import com.filipeoliveira.mymoviecatalog.data.local.model.MovieDB
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDAO {

    @Query("SELECT * FROM MovieDB")
    fun getFavoriteMovies() : Flow<List<MovieDB>>

    @Query("UPDATE MovieDB SET alreadyWatched = 1 WHERE id == :movieId")
    fun markMovieAsWatched(movieId: Int)

    @Query("UPDATE MovieDB SET alreadyWatched = 0 WHERE id == :movieId")
    fun markMovieAsNotWatched(movieId: Int)
}