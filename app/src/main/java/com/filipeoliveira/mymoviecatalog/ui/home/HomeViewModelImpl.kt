package com.filipeoliveira.mymoviecatalog.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.filipeoliveira.mymoviecatalog.domain.GetPopularMoviesUseCase
import com.filipeoliveira.mymoviecatalog.domain.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class HomeViewModelImpl @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
): ViewModel(), HomeViewModel {

    private var _screenHomeModel = MutableStateFlow(
        ScreenHomeModel(
            isLoading = true,
            error = null,
            data = emptyList()
        )
    )
    val screenHomeModel: StateFlow<ScreenHomeModel>
        get() = _screenHomeModel

    init {
        this.loadPopularMovieList()
    }

    override fun loadPopularMovieList() {
        _screenHomeModel = MutableStateFlow(
            ScreenHomeModel(
                isLoading = true,
                error = null,
                data = emptyList()
            )
        )

        viewModelScope.launch(Dispatchers.IO) {
            getPopularMoviesUseCase.execute(1)
                .catch {
                    _screenHomeModel = MutableStateFlow(
                        ScreenHomeModel(
                            isLoading = false,
                            error = it,
                            data = emptyList()
                        )
                    )
                }
                .collect{ result ->
                    when (result) {
                        is Result.Success -> {
                            _screenHomeModel.value = ScreenHomeModel(
                                isLoading = false,
                                error = null,
                                data = result.data
                            )
                        }

                        is Result.Error -> {
                            _screenHomeModel.value = ScreenHomeModel(
                                isLoading = false,
                                error = result.error,
                                data = emptyList()
                            )
                        }
                    }
                }
        }
    }
}