package com.filipeoliveira.mymoviecatalog.di

import com.filipeoliveira.mymoviecatalog.data.remote.MovieService
import com.filipeoliveira.mymoviecatalog.data.remote.RetrofitConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    @Provides
    @Singleton
    fun provideMovieService() : MovieService {
        return RetrofitConfig.service
    }
}