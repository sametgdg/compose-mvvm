package com.sametgdg.composesamplemvvm.data.model


data class PokeListResponse(
    val count: Int,
    val next: String?,
    val results: List<PokeListItem>
)

data class PokeListItem(
    val name: String,
    var id: String?
)