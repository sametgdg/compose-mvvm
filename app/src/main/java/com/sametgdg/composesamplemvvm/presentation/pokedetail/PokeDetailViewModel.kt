package com.sametgdg.composesamplemvvm.presentation.pokedetail

import androidx.lifecycle.ViewModel
import com.sametgdg.composesamplemvvm.data.repository.PokeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokeDetailViewModel @Inject constructor(
    repository: PokeRepository
) : ViewModel() {

}
