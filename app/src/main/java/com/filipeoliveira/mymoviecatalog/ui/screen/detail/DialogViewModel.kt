package com.filipeoliveira.mymoviecatalog.ui.screen.detail

import com.filipeoliveira.domain.model.Movie

interface DialogViewModel {
    fun isFavorite(movie: Movie)
    fun isWatched(movie: Movie)
    fun updateIsWatchedState(movie: Movie)
    fun updateIsFavoriteState(movie: Movie)
}