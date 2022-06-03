package com.sametgdg.composesamplemvvm.network

import com.sametgdg.composesamplemvvm.data.model.PokeListResponse
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET

interface PokeService {

    @GET("pokemon")
    suspend fun getPokemonList(): ApiResponse<PokeListResponse>
}