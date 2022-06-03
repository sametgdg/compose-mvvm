package com.sametgdg.composesamplemvvm.presentation.pokedetail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun PokeDetailScreen(navController: NavController, id: String) {
    Scaffold(topBar = {
        AppBar {
            navController.navigateUp()
        }
    }) {

    }
}


@Composable
fun AppBar(onClickBackButton: () -> Unit) {
    TopAppBar(
        navigationIcon = {
            Icon(
                Icons.Default.ArrowBack,
                "Back Button",
                Modifier
                    .padding(horizontal = 12.dp)
                    .clickable(onClick = onClickBackButton)
            )
        },
        title = { Text(text = "Detail Screen") }
    )
}