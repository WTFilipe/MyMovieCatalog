package com.filipeoliveira.mymoviecatalog.ui.screen.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.filipeoliveira.mymoviecatalog.R
import com.filipeoliveira.domain.model.Movie
import com.filipeoliveira.mymoviecatalog.TestTags.ADD_TO_FAVORITES_BUTTON
import com.filipeoliveira.mymoviecatalog.ui.components.OnLoading
import com.filipeoliveira.mymoviecatalog.ui.forwardingPainter
import com.filipeoliveira.mymoviecatalog.ui.theme.dimen16Dp
import com.filipeoliveira.mymoviecatalog.ui.theme.dimen2Dp
import com.filipeoliveira.mymoviecatalog.ui.theme.dimen4Dp
import com.filipeoliveira.mymoviecatalog.ui.theme.dimen8Dp

@Composable
fun DialogDetail(
    movie: Movie,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
    dialogViewModelImpl: DialogViewModelImpl = hiltViewModel()
) {
    dialogViewModelImpl.isFavorite(movie)
    dialogViewModelImpl.isWatched(movie)
    val uiState = dialogViewModelImpl.screenDialogState.collectAsState().value
    when {
        uiState.isFavorite == null -> {
            OnLoading()
        }

        else -> {
            ScreenContent(
                movie = movie,
                onDismiss = onDismiss,
                isFavorite = uiState.isFavorite,
                isWatched = uiState.isWatched ?: false,
                onFavoriteButtonClicked = { isFavorite ->
                    dialogViewModelImpl.updateIsFavoriteState(movie = movie.copy(isFavorite = isFavorite))
                },
                onWatchedButtonClicked = { isWatched ->
                    dialogViewModelImpl.updateIsWatchedState(movie = movie.copy(isWatched = isWatched))
                },
                modifier = modifier
            )
        }
    }

}

@Composable
private fun ScreenContent(
    movie: Movie,
    onDismiss: () -> Unit,
    isFavorite: Boolean,
    isWatched: Boolean,
    onFavoriteButtonClicked: (Boolean) -> Unit,
    onWatchedButtonClicked: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {

    Dialog(
        onDismissRequest = { onDismiss() },
    ) {
        Column(
            modifier = modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxWidth()
        ) {
            DialogDetailTop(movie)
            DialogDetailMiddle(
                isWatched = isWatched,
                isFavorite = isFavorite,
                onFavoriteButtonClicked = {
                    onFavoriteButtonClicked(!isFavorite)
                },
                onWatchedButtonClicked = {
                    onWatchedButtonClicked(!isWatched)
                }
            )
            DialogDetailBottom(movie)
        }
    }
}

@Composable
fun DialogDetailTop(movie: Movie, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
    ) {
        DialogDetailTopLeft(movie)
        DialogDetailTopRight(movie, Modifier.weight(1F))
    }
}

@Composable
fun DialogDetailTopLeft(movie: Movie) {
    AsyncImage(
        model = movie.getPosterURL(),
        contentDescription = null,
        modifier = Modifier,
        error = forwardingPainter(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface)
        ),
        placeholder = forwardingPainter(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface)
        ),
        contentScale = ContentScale.Fit
    )
}

@Composable
fun DialogDetailTopRight(movie: Movie, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(
                start = dimen8Dp,
                top = dimen16Dp,
                bottom = dimen16Dp,
                end = dimen16Dp
            )
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.label_title),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(dimen2Dp))
        Text(
            text = movie.title,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(dimen4Dp))

        Text(
            text = stringResource(R.string.label_original_title),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(dimen2Dp))
        Text(
            text = movie.original_title,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(dimen4Dp))
        Text(
            text = stringResource(R.string.label_votes),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(dimen2Dp))
        Text(
            text = movie.vote_count.toString(),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(dimen4Dp))
        Text(
            text = stringResource(R.string.label_note),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(dimen2Dp))
        Text(
            text = movie.vote_average.toString(),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Composable
fun DialogDetailMiddle(
    onFavoriteButtonClicked: () -> Unit,
    onWatchedButtonClicked: () -> Unit,
    modifier: Modifier = Modifier,
    isWatched: Boolean,
    isFavorite: Boolean
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(all = dimen16Dp),
        horizontalArrangement = if (isFavorite) Arrangement.SpaceBetween else Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (isFavorite) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable {
                        onWatchedButtonClicked()
                    }
            ) {
                Icon(
                    imageVector = if (isWatched) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.width(dimen2Dp))
                Text(
                    text = if (isWatched) stringResource(R.string.label_mark_as_not_watched) else stringResource(
                        R.string.label_mark_as_watched
                    ),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
            Spacer(modifier = Modifier.width(dimen8Dp))
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = if (isFavorite) Arrangement.End else Arrangement.Start,
            modifier = Modifier
                .clickable {
                    onFavoriteButtonClicked()
                }
                .testTag(ADD_TO_FAVORITES_BUTTON)
        ) {
            Icon(
                imageVector = if (isFavorite) Icons.Default.FavoriteBorder else Icons.Default.Favorite,
                contentDescription = null,
                modifier = Modifier
                    .height(IntrinsicSize.Max)
            )
            Spacer(modifier = Modifier.width(dimen2Dp))
            Text(
                text = if (isFavorite) stringResource(R.string.label_remove_from_favorites) else stringResource(
                    R.string.label_add_to_favorites
                ),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onBackground,
            )
        }
    }
}


@Composable
fun DialogDetailBottom(movie: Movie, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(start = dimen16Dp, end = dimen16Dp, bottom = dimen16Dp)
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.label_overview),
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(dimen2Dp))
        Text(
            text = movie.overview,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(dimen4Dp))
    }
}


@Preview
@Composable
fun ScreenContentPreview() {
    ScreenContent(
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
        ),
        isFavorite = true,
        isWatched = true,
        onDismiss = { },
        onFavoriteButtonClicked = {},
        onWatchedButtonClicked = {}
    )
}