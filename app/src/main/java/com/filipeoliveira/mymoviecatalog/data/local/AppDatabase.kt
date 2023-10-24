package com.filipeoliveira.mymoviecatalog.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.filipeoliveira.mymoviecatalog.data.local.model.MovieDB

@Database(entities = [MovieDB::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getMoviesDAO() : MovieDAO
}