package com.filipeoliveira.data.di


import com.filipeoliveira.data.MovieRepository
import com.filipeoliveira.data.MovieRepositoryImpl
import com.filipeoliveira.data.local.MovieLocalData
import com.filipeoliveira.data.local.MovieLocalDataImpl
import com.filipeoliveira.data.remote.MovieRemoteData
import com.filipeoliveira.data.remote.MovieRemoteDataImpl
import com.filipeoliveira.data.usecase.AddToFavoriteUseCaseImpl
import com.filipeoliveira.data.usecase.GetFavoriteMoviesUseCaseImpl
import com.filipeoliveira.data.usecase.GetPopularMoviesUseCaseImpl
import com.filipeoliveira.data.usecase.IsFavoriteUseCaseImpl
import com.filipeoliveira.data.usecase.IsWatchedUseCaseImpl
import com.filipeoliveira.data.usecase.MarkMovieAsNotWatchedUseCaseImpl
import com.filipeoliveira.data.usecase.MarkMovieAsWatchedUseCaseImpl
import com.filipeoliveira.data.usecase.RemoveFromFavoriteUseCaseImpl
import com.filipeoliveira.data.usecase.SearchMoviesUseCaseImpl
import com.filipeoliveira.domain.usecase.AddToFavoriteUseCase
import com.filipeoliveira.domain.usecase.GetFavoriteMoviesUseCase
import com.filipeoliveira.domain.usecase.GetPopularMoviesUseCase
import com.filipeoliveira.domain.usecase.IsFavoriteUseCase
import com.filipeoliveira.domain.usecase.IsWatchedUseCase
import com.filipeoliveira.domain.usecase.MarkMovieAsNotWatchedUseCase
import com.filipeoliveira.domain.usecase.MarkMovieAsWatchedUseCase
import com.filipeoliveira.domain.usecase.RemoveFromFavoriteUseCase
import com.filipeoliveira.domain.usecase.SearchMoviesUseCase
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