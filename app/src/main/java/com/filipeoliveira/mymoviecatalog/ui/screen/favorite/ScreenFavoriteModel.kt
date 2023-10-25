package com.filipeoliveira.mymoviecatalog.ui.screen.favorite

import com.filipeoliveira.domain.model.Movie

data class ScreenFavoriteModel(
    var isLoading: Boolean,
    var error: Throwable? = null,
    val data: List<Movie> = emptyList()
)
