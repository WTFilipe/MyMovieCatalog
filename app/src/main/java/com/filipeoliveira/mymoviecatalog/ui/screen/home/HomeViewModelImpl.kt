package com.filipeoliveira.mymoviecatalog.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.filipeoliveira.mymoviecatalog.data.Movie
import com.filipeoliveira.mymoviecatalog.domain.GetPopularMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModelImpl @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
): ViewModel(), HomeViewModel {

    private val _movieState: MutableStateFlow<PagingData<Movie>> = MutableStateFlow(value = PagingData.empty())
    val movieState: MutableStateFlow<PagingData<Movie>>
        get() = _movieState

    init {
        this.loadPopularMovieList()
    }

    override fun loadPopularMovieList() {
        viewModelScope.launch(Dispatchers.IO) {
            getPopularMoviesUseCase.execute()
                .collect{
                    _movieState.value = it
                }
        }
    }

}