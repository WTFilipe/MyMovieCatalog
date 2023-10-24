package com.filipeoliveira.mymoviecatalog.di

import com.filipeoliveira.mymoviecatalog.data.MovieRepository
import com.filipeoliveira.mymoviecatalog.data.MovieRepositoryImpl
import com.filipeoliveira.mymoviecatalog.data.remote.MovieRemoteData
import com.filipeoliveira.mymoviecatalog.data.remote.MovieRemoteDataImpl
import com.filipeoliveira.mymoviecatalog.domain.GetPopularMoviesUseCase
import com.filipeoliveira.mymoviecatalog.domain.GetPopularMoviesUseCaseImpl
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
    abstract fun providesMovieRepository(repository: MovieRepositoryImpl) : MovieRepository
    @Binds
    abstract fun providesGetPopularMoviesUseCase(getPopularMoviesUseCaseImpl: GetPopularMoviesUseCaseImpl) : GetPopularMoviesUseCase
}