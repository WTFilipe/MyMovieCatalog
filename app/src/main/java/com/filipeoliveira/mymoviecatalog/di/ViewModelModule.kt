package com.filipeoliveira.mymoviecatalog.di

import com.filipeoliveira.mymoviecatalog.ui.home.HomeViewModel
import com.filipeoliveira.mymoviecatalog.ui.home.HomeViewModelImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ViewModelModule {
    @Binds
    abstract fun providesHomeViewModel(
        homeViewModel: HomeViewModelImpl
    ): HomeViewModel

}