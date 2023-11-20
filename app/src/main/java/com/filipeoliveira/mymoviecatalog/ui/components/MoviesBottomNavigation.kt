package com.filipeoliveira.mymoviecatalog.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.filipeoliveira.mymoviecatalog.TestTags.BOTTOM_NAV_FAVORITE
import com.filipeoliveira.mymoviecatalog.TestTags.BOTTOM_NAV_HOME
import com.filipeoliveira.mymoviecatalog.TestTags.BOTTOM_NAV_SEARCH
import com.filipeoliveira.mymoviecatalog.ui.screen.Screens

@Composable
fun MoviesBottomNavigation (
    navController: NavController,
    items: List<Screens>,
    modifier: Modifier = Modifier
){
    NavigationBar(
        modifier = modifier
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        items.forEach { screen ->
            NavigationBarItem(
                icon = { Icon(screen.icon, null)},
                label = { Text(stringResource(screen.title)) },
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true ,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                modifier = Modifier.testTag(
                    when(screen){
                        Screens.Home -> BOTTOM_NAV_HOME
                        Screens.Search -> BOTTOM_NAV_SEARCH
                        else -> BOTTOM_NAV_FAVORITE
                    }
                )
            )
        }
    }
}