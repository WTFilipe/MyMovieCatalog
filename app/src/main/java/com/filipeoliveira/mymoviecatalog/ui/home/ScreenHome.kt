package com.filipeoliveira.mymoviecatalog.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.filipeoliveira.mymoviecatalog.data.Movie
import com.filipeoliveira.mymoviecatalog.ui.Loading
import com.filipeoliveira.mymoviecatalog.ui.OnError
import com.filipeoliveira.mymoviecatalog.ui.theme.dimen16Dp
import com.filipeoliveira.mymoviecatalog.ui.theme.dimen8Dp

@Composable
fun ScreenHome(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModelImpl = hiltViewModel()
){
    Surface(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
    ) {
        val uiState = viewModel.screenHomeModel.collectAsState().value

        when {
            uiState.isLoading -> { Loading() }
            uiState.error != null -> { OnError(uiState.error!!) }
            uiState.data.isNotEmpty() -> { OnDataSuccess(uiState.data) }
        }
    }
}

@Composable
fun OnDataSuccess(data: List<Movie>, modifier: Modifier = Modifier) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        verticalItemSpacing = dimen8Dp,
        horizontalArrangement = Arrangement.spacedBy(dimen8Dp),
        modifier = modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(horizontal = dimen16Dp, vertical = dimen16Dp)
    ) {
        items(data.size){
            MovieItem(data[it])
        }
    }
}

@Preview
@Composable
fun OnDataSuccessPreview(){
    OnDataSuccess(List(5){
        Movie(
            adult = false,
            backdrop_path = "/tC78Pck2YCsUAtEdZwuHYUFYtOj.jpg",
            genre_ids = listOf(28,53,80),
            id = 926393,
            original_language = "en",
            original_title = "The Equalizer 3",
            overview = "Sentindo-se em casa no sul da Itália, o ex-agente Robert McCall logo descobre que seus novos amigos estão sob o controle dos chefes do crime local.  À medida que os acontecimentos se tornam mortais, McCall sabe o que tem de fazer: tornar-se o protetor dos seus amigos, enfrentando a máfia.",
            popularity = 1924.03,
            poster_path = "/AnJOKbSQsp0QqiUhsQooqFRjPsD.jpg",
            release_date = "2023-08-30",
            title = "O Protetor: Capítulo Final",
            vote_count = 23,
            vote_average = 4.7,
            video = false
        )
    })
}