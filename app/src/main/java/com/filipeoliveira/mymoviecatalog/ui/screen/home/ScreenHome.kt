package com.filipeoliveira.mymoviecatalog.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.filipeoliveira.mymoviecatalog.data.Movie
import com.filipeoliveira.mymoviecatalog.ui.components.OnError
import com.filipeoliveira.mymoviecatalog.ui.components.OnLoading
import com.filipeoliveira.mymoviecatalog.ui.screen.detail.DialogDetail
import com.filipeoliveira.mymoviecatalog.ui.theme.dimen16Dp
import com.filipeoliveira.mymoviecatalog.ui.theme.dimen8Dp

@Composable
fun ScreenHome(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModelImpl = hiltViewModel()
) {
    Box(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center,
    ) {
        val uiState: LazyPagingItems<Movie> = viewModel.movieState.collectAsLazyPagingItems()
        var showMovieDetail by rememberSaveable{
            mutableStateOf<Movie?>(null)
        }

        LazyVerticalStaggeredGrid(
            columns =
            if (uiState.loadState.refresh is LoadState.Loading) {
                StaggeredGridCells.Fixed(1)
            } else {
                StaggeredGridCells.Fixed(2)
            },
            verticalItemSpacing = dimen8Dp,
            horizontalArrangement = Arrangement.spacedBy(dimen8Dp),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = dimen16Dp, vertical = dimen16Dp)
        ) {
            items(uiState.itemCount) { index ->
                uiState[index]?.let { MovieItem(it){ movie ->
                    showMovieDetail = movie
                } }
            }

            uiState.apply {
                when {
                    loadState.refresh is LoadState.Loading -> {
                        item { OnLoading(modifier = Modifier.fillMaxSize()) }
                    }

                    loadState.refresh is LoadState.Error -> {
                        val error = uiState.loadState.refresh as LoadState.Error
                        item {
                            OnError(
                                modifier = Modifier.fillMaxSize(),
                                error = error.error,
                                onClick = { retry() }
                            )
                        }
                    }

                    loadState.append is LoadState.Loading -> {
                        item { OnLoading(modifier = Modifier) }
                    }

                    loadState.append is LoadState.Error -> {
                        val error = uiState.loadState.append as LoadState.Error
                        item {
                            OnError(
                                modifier = Modifier.fillMaxSize(),
                                error = error.error,
                                onClick = { retry() }
                            )
                        }
                    }
                }
            }
        }

        showMovieDetail?.let {
            DialogDetail(
                movie = it,
                onDismiss = {
                    showMovieDetail = null
                }
            )
        }
    }
}

