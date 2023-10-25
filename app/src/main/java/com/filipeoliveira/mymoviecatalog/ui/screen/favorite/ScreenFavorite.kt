package com.filipeoliveira.mymoviecatalog.ui.screen.favorite

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.filipeoliveira.mymoviecatalog.data.Movie
import com.filipeoliveira.mymoviecatalog.ui.components.OnError
import com.filipeoliveira.mymoviecatalog.ui.components.OnLoading
import com.filipeoliveira.mymoviecatalog.ui.screen.home.MovieItem
import com.filipeoliveira.mymoviecatalog.ui.theme.dimen16Dp
import com.filipeoliveira.mymoviecatalog.ui.theme.dimen8Dp

@Composable
fun ScreenFavorite(
    modifier: Modifier = Modifier,
    favoriteViewModel: FavoriteViewModelImpl = hiltViewModel()
) {
    val uiState = favoriteViewModel.favoriteState.collectAsState().value

    when{
        uiState.error != null -> { uiState.error?.let { OnError(it, modifier = modifier) } }
        uiState.isLoading -> { OnLoading(modifier = modifier.fillMaxSize()) }
        uiState.data.isNotEmpty() -> { OnDataSuccess(uiState.data, modifier) }
    }
}

@Composable
fun OnDataSuccess(data: List<Movie>, modifier: Modifier = Modifier) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        verticalItemSpacing = dimen8Dp,
        horizontalArrangement = Arrangement.spacedBy(dimen8Dp),
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = dimen16Dp, vertical = dimen16Dp)
    ) {
        items(data.size) { index ->
            MovieItem(data[index])
        }
    }
}

@Preview
@Composable
fun OnDataSuccessPreview() {
    OnDataSuccess(List(5) {
        Movie(
            adult = false,
            id = 926393,
            original_title = "The Equalizer 3",
            overview = "Sentindo-se em casa no sul da Itália, o ex-agente Robert McCall logo descobre que seus novos amigos estão sob o controle dos chefes do crime local.  À medida que os acontecimentos se tornam mortais, McCall sabe o que tem de fazer: tornar-se o protetor dos seus amigos, enfrentando a máfia.",
            poster_path = "/AnJOKbSQsp0QqiUhsQooqFRjPsD.jpg",
            release_date = "2023-08-30",
            title = "O Protetor: Capítulo Final",
            vote_count = 23,
            vote_average = 4.7,
        )
    })
}