package com.filipeoliveira.mymoviecatalog.domain

import com.filipeoliveira.mymoviecatalog.data.Movie

interface RemoveFromFavoriteUseCase {
    suspend fun execute(movie: Movie)
}