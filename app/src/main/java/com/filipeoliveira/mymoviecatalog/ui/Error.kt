package com.filipeoliveira.mymoviecatalog.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.filipeoliveira.mymoviecatalog.R
import com.filipeoliveira.mymoviecatalog.domain.error.EmptyResponseError

@Composable
fun OnError(
    error: Throwable,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    val errorText = when (error) {
        is EmptyResponseError -> stringResource(R.string.error_empty_response)
        else -> stringResource(R.string.error_generic)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .clickable {
                onClick?.let { it() }
            }
    ) {
        Text(
            text = errorText,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground,
        )
    }
}