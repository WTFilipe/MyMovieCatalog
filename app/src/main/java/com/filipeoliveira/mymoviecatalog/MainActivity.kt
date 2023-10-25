package com.filipeoliveira.mymoviecatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.filipeoliveira.mymoviecatalog.ui.components.MoviesBottomNavigation
import com.filipeoliveira.mymoviecatalog.ui.screen.Screens
import com.filipeoliveira.mymoviecatalog.ui.screen.favorite.ScreenFavorite
import com.filipeoliveira.mymoviecatalog.ui.screen.home.ScreenHome
import com.filipeoliveira.mymoviecatalog.ui.screen.search.ScreenSearch
import com.filipeoliveira.mymoviecatalog.ui.theme.MyMovieCatalogTheme
import com.filipeoliveira.mymoviecatalog.ui.theme.dimen2Dp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyMovieCatalogTheme {
                val navController = rememberNavController()

                val screensInBottomNav = listOf(
                    Screens.Home,
                    Screens.Search,
                    Screens.Favorites
                )

                Scaffold(
                    topBar = {
                        Surface(shadowElevation = dimen2Dp) {
                            TopAppBar(
                                title = {
                                    Text(
                                        text = stringResource(R.string.app_name),
                                    )
                                }
                            )
                        }
                    },
                    bottomBar = { MoviesBottomNavigation(navController, screensInBottomNav) }
                ) { paddingValues ->
                    NavHost(
                        navController = navController,
                        startDestination = Screens.Home.route,
                        modifier = Modifier.padding(paddingValues)
                    ) {
                        composable(Screens.Home.route) { ScreenHome() }
                        composable(Screens.Favorites.route) { ScreenFavorite() }
                        composable(Screens.Search.route) { ScreenSearch() }
                    }
                }
            }
        }
    }
}
