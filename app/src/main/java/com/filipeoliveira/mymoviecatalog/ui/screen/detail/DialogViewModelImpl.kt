package com.filipeoliveira.mymoviecatalog.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.filipeoliveira.mymoviecatalog.data.Movie
import com.filipeoliveira.mymoviecatalog.domain.AddToFavoriteUseCase
import com.filipeoliveira.mymoviecatalog.domain.IsFavoriteUseCase
import com.filipeoliveira.mymoviecatalog.domain.IsWatchedUseCase
import com.filipeoliveira.mymoviecatalog.domain.MarkMovieAsNotWatchedUseCase
import com.filipeoliveira.mymoviecatalog.domain.MarkMovieAsWatchedUseCase
import com.filipeoliveira.mymoviecatalog.domain.RemoveFromFavoriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DialogViewModelImpl @Inject constructor(
    private val isFavoriteUseCase: IsFavoriteUseCase,
    private val isWatchedUseCase: IsWatchedUseCase,
    private val markMovieAsWatchedUseCase: MarkMovieAsWatchedUseCase,
    private val markMovieAsNotWatchedUseCase: MarkMovieAsNotWatchedUseCase,
    private val addToFavoriteUseCase: AddToFavoriteUseCase,
    private val removeFromFavoriteUseCase: RemoveFromFavoriteUseCase,
): ViewModel(), DialogViewModel {

    private val _screenDialogState: MutableStateFlow<ScreenDialogModel> = MutableStateFlow(
        ScreenDialogModel()
    )
    val screenDialogState: MutableStateFlow<ScreenDialogModel>
        get() = _screenDialogState

    override fun isFavorite(movie: Movie) {
        viewModelScope.launch(Dispatchers.IO) {
            isFavoriteUseCase.execute(movie = movie)
                .catch {
                    _screenDialogState.value = _screenDialogState.value.copy(
                        isFavorite = false
                    )
                }
                .collect {
                    _screenDialogState.value = _screenDialogState.value.copy(
                        isFavorite = it
                    )
                }
        }
    }

    override fun isWatched(movie: Movie) {
        viewModelScope.launch(Dispatchers.IO) {
            isWatchedUseCase.execute(movie = movie)
                .catch {
                    _screenDialogState.value = _screenDialogState.value.copy(
                        isWatched = false
                    )
                }
                .collect {
                    _screenDialogState.value = _screenDialogState.value.copy(
                        isWatched = it
                    )
                }
        }
    }

    override fun updateIsWatchedState(movie: Movie) {
        viewModelScope.launch(Dispatchers.IO) {
            if (movie.isWatched){
                markMovieAsWatchedUseCase.execute(movie = movie)
            } else {
                markMovieAsNotWatchedUseCase.execute(movie = movie)
            }
        }
    }

    override fun updateIsFavoriteState(movie: Movie) {
        viewModelScope.launch(Dispatchers.IO) {
            if (movie.isFavorite){
                addToFavoriteUseCase.execute(movie = movie)
            } else {
                removeFromFavoriteUseCase.execute(movie = movie)
            }
        }
    }

}