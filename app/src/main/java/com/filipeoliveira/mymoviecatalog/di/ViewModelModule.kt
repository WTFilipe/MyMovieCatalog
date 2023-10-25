package com.filipeoliveira.mymoviecatalog.di

import com.filipeoliveira.mymoviecatalog.ui.screen.detail.DialogViewModel
import com.filipeoliveira.mymoviecatalog.ui.screen.detail.DialogViewModelImpl
import com.filipeoliveira.mymoviecatalog.ui.screen.favorite.FavoriteViewModel
import com.filipeoliveira.mymoviecatalog.ui.screen.favorite.FavoriteViewModelImpl
import com.filipeoliveira.mymoviecatalog.ui.screen.home.HomeViewModel
import com.filipeoliveira.mymoviecatalog.ui.screen.home.HomeViewModelImpl
import com.filipeoliveira.mymoviecatalog.ui.screen.search.SearchViewModel
import com.filipeoliveira.mymoviecatalog.ui.screen.search.SearchViewModelImpl
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

    @Binds
    abstract fun providesFavoriteViewModel(
        favoriteViewModel: FavoriteViewModelImpl
    ): FavoriteViewModel

    @Binds
    abstract fun providesDialogViewModel(
        dialogViewModelImpl: DialogViewModelImpl
    ): DialogViewModel

    @Binds
    abstract fun providesSearchViewModel(
       searchViewModelImpl: SearchViewModelImpl
    ): SearchViewModel

}