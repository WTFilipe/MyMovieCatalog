package com.filipeoliveira.mymoviecatalog.di

import com.filipeoliveira.mymoviecatalog.data.MovieRepository
import com.filipeoliveira.mymoviecatalog.data.MovieRepositoryImpl
import com.filipeoliveira.mymoviecatalog.data.local.MovieLocalData
import com.filipeoliveira.mymoviecatalog.data.local.MovieLocalDataImpl
import com.filipeoliveira.mymoviecatalog.data.remote.MovieRemoteData
import com.filipeoliveira.mymoviecatalog.data.remote.MovieRemoteDataImpl
import com.filipeoliveira.mymoviecatalog.domain.AddToFavoriteUseCase
import com.filipeoliveira.mymoviecatalog.domain.AddToFavoriteUseCaseImpl
import com.filipeoliveira.mymoviecatalog.domain.GetFavoriteMoviesUseCase
import com.filipeoliveira.mymoviecatalog.domain.GetFavoriteMoviesUseCaseImpl
import com.filipeoliveira.mymoviecatalog.domain.GetPopularMoviesUseCase
import com.filipeoliveira.mymoviecatalog.domain.GetPopularMoviesUseCaseImpl
import com.filipeoliveira.mymoviecatalog.domain.IsFavoriteUseCase
import com.filipeoliveira.mymoviecatalog.domain.IsFavoriteUseCaseImpl
import com.filipeoliveira.mymoviecatalog.domain.IsWatchedUseCase
import com.filipeoliveira.mymoviecatalog.domain.IsWatchedUseCaseImpl
import com.filipeoliveira.mymoviecatalog.domain.MarkMovieAsNotWatchedUseCase
import com.filipeoliveira.mymoviecatalog.domain.MarkMovieAsNotWatchedUseCaseImpl
import com.filipeoliveira.mymoviecatalog.domain.RemoveFromFavoriteUseCase
import com.filipeoliveira.mymoviecatalog.domain.RemoveFromFavoriteUseCaseImpl
import com.filipeoliveira.mymoviecatalog.domain.MarkMovieAsWatchedUseCase
import com.filipeoliveira.mymoviecatalog.domain.MarkMovieAsWatchedUseCaseImpl
import com.filipeoliveira.mymoviecatalog.domain.SearchMoviesUseCase
import com.filipeoliveira.mymoviecatalog.domain.SearchMoviesUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    abstract fun providesMovieRemoteData(remoteData: MovieRemoteDataImpl) : MovieRemoteData
    @Binds
    abstract fun providesMovieLocalData(remoteData: MovieLocalDataImpl) : MovieLocalData
    @Binds
    abstract fun providesMovieRepository(repository: MovieRepositoryImpl) : MovieRepository
    @Binds
    abstract fun providesGetPopularMoviesUseCase(getPopularMoviesUseCaseImpl: GetPopularMoviesUseCaseImpl) : GetPopularMoviesUseCase
    @Binds
    abstract fun providesGetFavoriteMoviesUseCase(getFavoriteMoviesUseCase: GetFavoriteMoviesUseCaseImpl) : GetFavoriteMoviesUseCase
    @Binds
    abstract fun providesAddToFavoritesUseCase(addToFavoriteUseCase: AddToFavoriteUseCaseImpl) : AddToFavoriteUseCase
    @Binds
    abstract fun providesRemoveToFavoritesUseCase(removeFromFavoriteUseCaseImpl: RemoveFromFavoriteUseCaseImpl) : RemoveFromFavoriteUseCase
    @Binds
    abstract fun providesIsFavoriteUseCase(isFavoriteUseCaseImpl: IsFavoriteUseCaseImpl) : IsFavoriteUseCase
    @Binds
    abstract fun providesIsWatchedUseCase(isWatchedUseCaseImpl: IsWatchedUseCaseImpl) : IsWatchedUseCase
    @Binds
    abstract fun providesMarkMovieAsWatchedUseCase(markMovieAsWatchedUseCaseImpl: MarkMovieAsWatchedUseCaseImpl) : MarkMovieAsWatchedUseCase
    @Binds
    abstract fun providesMarkMovieAsNotWatchedUseCase(markMovieAsNotWatchedUseCaseImpl: MarkMovieAsNotWatchedUseCaseImpl) : MarkMovieAsNotWatchedUseCase
    @Binds
    abstract fun providesSearchMoviesUseCase(searchMoviesUseCaseImpl: SearchMoviesUseCaseImpl) : SearchMoviesUseCase
}