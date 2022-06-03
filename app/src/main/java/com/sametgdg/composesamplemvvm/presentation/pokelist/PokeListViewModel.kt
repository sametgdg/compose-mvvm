package com.sametgdg.composesamplemvvm.presentation.pokelist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.sametgdg.composesamplemvvm.data.model.PokeListResponse
import com.sametgdg.composesamplemvvm.data.repository.PokeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class PokeListViewModel @Inject constructor(
    repository: PokeRepository
) : ViewModel() {

    val pokeList: Flow<PokeListResponse> =
        repository.loadPokemons(
            onStart = {
                _isLoading.value = true
            },
            onCompletion = {
                _isLoading.value = false
            },
            onError = {

            }
        )

    private val _isLoading: MutableState<Boolean> = mutableStateOf(false)
    val isLoading: State<Boolean> get() = _isLoading



}
