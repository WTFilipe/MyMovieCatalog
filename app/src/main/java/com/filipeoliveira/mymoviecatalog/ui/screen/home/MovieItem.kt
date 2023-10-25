package com.filipeoliveira.mymoviecatalog.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.filipeoliveira.mymoviecatalog.R
import com.filipeoliveira.mymoviecatalog.data.Movie
import com.filipeoliveira.mymoviecatalog.ui.forwardingPainter
import com.filipeoliveira.mymoviecatalog.ui.theme.dimen4Dp
import com.filipeoliveira.mymoviecatalog.ui.theme.dimen8Dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieItem(
    movie: Movie,
    modifier: Modifier = Modifier,
    isDisabled: Boolean = false,
    onCardClicked: ((Movie) -> Unit)? = null
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
            .alpha(if (isDisabled) 0.4F else 1.0F),
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimen8Dp
        ),
        onClick = {
            onCardClicked?.let { it(movie) }
        }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
        ) {
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
            Spacer(modifier = Modifier.height(dimen8Dp))
            Text(
                text = movie.title,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(horizontal = dimen8Dp)
            )
            Spacer(modifier = Modifier.height(dimen4Dp))
            Text(
                text = "(${movie.getReleaseYear()})",
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(horizontal = dimen8Dp)
            )
            Spacer(modifier = Modifier.height(dimen8Dp))
        }

    }
}

@Preview
@Composable
fun MovieItemPreview() {
    MovieItem(
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
    )
}