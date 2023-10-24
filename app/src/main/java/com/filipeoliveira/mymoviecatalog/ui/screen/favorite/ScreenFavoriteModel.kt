package com.filipeoliveira.mymoviecatalog.ui.screen.favorite

import com.filipeoliveira.mymoviecatalog.data.Movie

data class ScreenFavoriteModel(
    var isLoading: Boolean,
    var error: Throwable? = null,
    val data: List<Movie> = emptyList()
)
