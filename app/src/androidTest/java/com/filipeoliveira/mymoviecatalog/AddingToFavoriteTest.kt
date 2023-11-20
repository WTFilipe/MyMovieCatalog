package com.filipeoliveira.mymoviecatalog

import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performImeAction
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.test.espresso.Espresso
import com.filipeoliveira.mymoviecatalog.TestTags.ADD_TO_FAVORITES_BUTTON
import com.filipeoliveira.mymoviecatalog.TestTags.BOTTOM_NAV_FAVORITE
import com.filipeoliveira.mymoviecatalog.TestTags.BOTTOM_NAV_SEARCH
import com.filipeoliveira.mymoviecatalog.TestTags.MOVIE_ITEM
import com.filipeoliveira.mymoviecatalog.TestTags.SEARCH_TEXT_FIELD
import com.filipeoliveira.mymoviecatalog.ui.components.MoviesBottomNavigation
import com.filipeoliveira.mymoviecatalog.ui.screen.Screens
import com.filipeoliveira.mymoviecatalog.ui.screen.favorite.ScreenFavorite
import com.filipeoliveira.mymoviecatalog.ui.screen.home.ScreenHome
import com.filipeoliveira.mymoviecatalog.ui.screen.search.ScreenSearch
import com.filipeoliveira.mymoviecatalog.ui.theme.MyMovieCatalogTheme
import com.filipeoliveira.mymoviecatalog.ui.theme.dimen2Dp
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
@UninstallModules(RoomModule::class)
class AddingToFavoriteTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()

    @OptIn(ExperimentalMaterial3Api::class)
    @ExperimentalAnimationApi
    @Before
    fun setUp() {
        hiltRule.inject()
        composeRule.activity.setContent {
            MyMovieCatalogTheme{
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
                                },
                                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp))
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

    @Test
    fun addToFavoritesAndSeeItOnFavoriteList() {
        composeRule.onNodeWithTag(BOTTOM_NAV_SEARCH, useUnmergedTree = true).assertIsDisplayed()
        composeRule.onNodeWithTag(BOTTOM_NAV_SEARCH, useUnmergedTree = true).performClick()
        composeRule.onNodeWithTag(SEARCH_TEXT_FIELD).performTextInput("mario")
        composeRule.onNodeWithTag(SEARCH_TEXT_FIELD).performImeAction()

        composeRule.waitUntil(timeoutMillis = 5000){
            composeRule.onAllNodesWithTag(MOVIE_ITEM).fetchSemanticsNodes().isNotEmpty()
        }

        composeRule.onAllNodesWithText("Mario", ignoreCase = true)[1].performClick()

        composeRule.waitUntil(timeoutMillis = 5000){
            composeRule.onAllNodesWithTag(ADD_TO_FAVORITES_BUTTON).fetchSemanticsNodes().isNotEmpty()
        }

        composeRule.onNodeWithTag(ADD_TO_FAVORITES_BUTTON).performClick()

        Espresso.pressBack()
        composeRule.onNodeWithTag(BOTTOM_NAV_FAVORITE, useUnmergedTree = true).performClick()
        composeRule.onNodeWithTag(MOVIE_ITEM).assertIsDisplayed()
    }
}