package com.filipeoliveira.mymoviecatalog.ui.home

import com.filipeoliveira.mymoviecatalog.data.Movie

data class ScreenHomeModel(
    var isLoading: Boolean = false,
    var error: Throwable? = null,
    var data: List<Movie> = emptyList()
)
