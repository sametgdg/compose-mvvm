package com.sametgdg.composesamplemvvm.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun DisneyApplication() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavScreen.Home.route) {
        composable(
            route = NavScreen.Home.route
        ) {
            // ListScreen
        }

        composable(
            route = NavScreen.PosterDetails.route,
            arguments = listOf(
                navArgument(NavScreen.PosterDetails.argPosterId) {
                    type = NavType.LongType
                }
            )
        ) {
            // DetailScreen
        }

    }
}


sealed class NavScreen(val route: String) {

    object Home : NavScreen("Home")

    object PosterDetails : NavScreen("PosterDetails") {

        const val routeWithArgument: String = "PosterDetails/{posterId}"

        const val argPosterId: String = "posterId"
    }
}
