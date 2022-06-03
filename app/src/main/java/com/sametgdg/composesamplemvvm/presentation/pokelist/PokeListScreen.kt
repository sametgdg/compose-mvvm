package com.sametgdg.composesamplemvvm.presentation.pokelist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.sametgdg.composesamplemvvm.data.model.PokeListResponse
import com.sametgdg.composesamplemvvm.presentation.NavScreen
import com.sametgdg.composesamplemvvm.utils.extension.visible

@Composable
fun PokeListScreen(viewModel: PokeListViewModel, navController: NavHostController) {

    val listResponse: PokeListResponse by viewModel.pokeList.collectAsState(getEmptyResponse())
    val isLoading: Boolean by viewModel.isLoading
    val listState = rememberLazyListState()

    Scaffold(
        topBar = { AppBar() }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn(
                state = listState
            ) {
                items(listResponse.results) {
                    PokeItem(name = it.name, id = it.name) {
                        navController.navigate("${NavScreen.PokeDetails.route}/$it")
                    }
                }
            }
            CircularProgressIndicator(
                modifier = Modifier
                    .wrapContentSize(align = Alignment.Center)
                    .visible(isLoading)
            )
        }
    }
}

@Composable
fun AppBar() {
    TopAppBar(
        navigationIcon = {
            Icon(
                Icons.Default.Home,
                "Back Button",
                Modifier.padding(horizontal = 12.dp)
            )
        },
        title = { Text(text = "List Screen") }
    )
}

@Composable
fun PokeItem(name: String, id: String, onItemClickBlock: () -> Unit) {
    Card(
        modifier = Modifier
            .clickable(onClick = onItemClickBlock)
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top),
        elevation = 8.dp,
        backgroundColor = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = name, style = MaterialTheme.typography.h3)
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = id, style = MaterialTheme.typography.h5)
        }
    }
}


private fun getEmptyResponse(): PokeListResponse {
    return PokeListResponse(
        0,
        "",
        emptyList()
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultDetailPreview() {
    PokeItem(name = "Pikaa", id = "1") {

    }
}