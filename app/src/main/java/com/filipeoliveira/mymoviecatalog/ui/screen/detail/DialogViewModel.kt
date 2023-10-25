package com.filipeoliveira.mymoviecatalog.ui.screen.detail

import com.filipeoliveira.mymoviecatalog.data.Movie

interface DialogViewModel {
    fun isFavorite(movie: Movie)
    fun isWatched(movie: Movie)
    fun updateIsWatchedState(movie: Movie)
    fun updateIsFavoriteState(movie: Movie)
}