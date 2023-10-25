package com.filipeoliveira.mymoviecatalog.ui.screen.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LoadState
import androidx.paging.LoadStates
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.filipeoliveira.domain.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class SearchViewModelImpl @Inject constructor(
    private val searchMoviesUseCase: com.filipeoliveira.domain.usecase.SearchMoviesUseCase
) : SearchViewModel, ViewModel() {

    private val _movieState: MutableStateFlow<PagingData<Movie>> = MutableStateFlow(value = PagingData.empty(
        LoadStates(
            append = LoadState.NotLoading(false),
            prepend = LoadState.NotLoading(false),
            refresh = LoadState.NotLoading(false),
        )
    ))
    val movieState: MutableStateFlow<PagingData<Movie>>
        get() = _movieState

    override fun search(query: String) {
        _movieState.value = PagingData.empty(LoadStates(
            append = LoadState.NotLoading(false),
            prepend = LoadState.NotLoading(false),
            refresh = LoadState.Loading,
        ))
        viewModelScope.launch(Dispatchers.IO) {
            searchMoviesUseCase.execute(query).cachedIn(viewModelScope)
                .collect{
                    _movieState.value = it
                }
        }
    }

}