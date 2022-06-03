package com.sametgdg.composesamplemvvm.presentation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sametgdg.composesamplemvvm.presentation.pokedetail.PokeDetailScreen
import com.sametgdg.composesamplemvvm.presentation.pokelist.PokeListScreen

@Composable
fun DisneyApplication() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavScreen.PokeList.route) {
        composable(
            route = NavScreen.PokeList.route
        ) {
            PokeListScreen(viewModel = hiltViewModel(), navController)
        }

        composable(
            route = NavScreen.PokeDetails.routeWithArgument,
            arguments = listOf(
                navArgument(NavScreen.PokeDetails.argId) {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getString(NavScreen.PokeDetails.argId)
                ?: return@composable
            PokeDetailScreen(navController = navController, id = id)
        }

    }
}


sealed class NavScreen(val route: String) {
    object PokeList : NavScreen("PokeList")
    object PokeDetails : NavScreen("PokeDetails") {
        const val routeWithArgument: String = "PokeDetails/{id}"
        const val argId: String = "id"
    }
}
