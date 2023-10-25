package com.filipeoliveira.mymoviecatalog.domain

import com.filipeoliveira.mymoviecatalog.data.Movie

interface AddToFavoriteUseCase {
    suspend fun execute(movie: Movie)
}