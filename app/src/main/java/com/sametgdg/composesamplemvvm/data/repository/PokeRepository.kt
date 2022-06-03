package com.sametgdg.composesamplemvvm.data.repository

import androidx.annotation.WorkerThread
import com.sametgdg.composesamplemvvm.network.PokeService
import com.skydoves.sandwich.message
import com.skydoves.sandwich.onFailure
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class PokeRepository @Inject constructor(
    private val service: PokeService
) {

    @WorkerThread
    fun loadPokemons(
        onStart: () -> Unit,
        onCompletion: () -> Unit,
        onError: (String) -> Unit
    ) = flow {
        service.getPokemonList().suspendOnSuccess {
            emit(data)
        }.onFailure { onError(message()) }
    }.onStart { onStart() }.onCompletion { onCompletion() }.flowOn(Dispatchers.IO)
}
