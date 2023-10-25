package com.filipeoliveira.mymoviecatalog.ui.screen.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.filipeoliveira.domain.usecase.GetFavoriteMoviesUseCase
import com.filipeoliveira.domain.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModelImpl @Inject constructor(
    private val getFavoriteMoviesUseCase: com.filipeoliveira.domain.usecase.GetFavoriteMoviesUseCase
) : ViewModel(), FavoriteViewModel {

    private val _favoriteState: MutableStateFlow<ScreenFavoriteModel> = MutableStateFlow(
        ScreenFavoriteModel(
            isLoading = true,
            error = null
        )
    )
    val favoriteState: MutableStateFlow<ScreenFavoriteModel>
        get() = _favoriteState

    init {
        this.loadFavoriteMovieList()
    }

    override fun loadFavoriteMovieList() {
        _favoriteState.value = ScreenFavoriteModel(
            isLoading = true,
            error = null
        )

        viewModelScope.launch(Dispatchers.IO) {
            getFavoriteMoviesUseCase.execute()
                .catch {
                    _favoriteState.value = ScreenFavoriteModel(
                        isLoading = false,
                        error = it,
                        data = emptyList()
                    )
                }
                .collect { result ->
                    when (result) {
                        is Result.Error -> {
                            _favoriteState.value = ScreenFavoriteModel(
                                isLoading = false,
                                error = result.error,
                                data = emptyList()
                            )
                        }

                        is Result.Success -> {
                            _favoriteState.value = ScreenFavoriteModel(
                                isLoading = false,
                                error = null,
                                data = result.data
                            )
                        }
                    }
                }
        }
    }


}