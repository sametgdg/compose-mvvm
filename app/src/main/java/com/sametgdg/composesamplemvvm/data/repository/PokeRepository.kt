/*
 * Designed and developed by 2020 skydoves (Jaewoong Eum)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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

       /* val posters: List<Poster> = posterDao.getPosterList()
        if (posters.isEmpty()) {
            // request API network call asynchronously.
            disneyService.fetchDisneyPosterList()
                // handle the case when the API request gets a success response.
                .suspendOnSuccess {
                    posterDao.insertPosterList(data)
                    emit(data)
                }
                // handle the case when the API request is fails.
                // e.g. internal server error.
                .onFailure { onError(message()) }
        } else {
            emit(posters)
        }*/
    }.onStart { onStart() }.onCompletion { onCompletion() }.flowOn(Dispatchers.IO)
}
