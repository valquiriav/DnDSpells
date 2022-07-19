package com.valquiria.dndspells.data.remote

import com.valquiria.dndspells.data.remote.response.SpellItemResponse
import retrofit2.http.GET

interface SpellsApi {

    @GET("spells/")
    suspend fun getSpells(): MutableList<SpellItemResponse>

}