package com.valquiria.dndspells.data.remote

import androidx.lifecycle.LiveData
import com.valquiria.dndspells.data.remote.response.SpellListResponse
import retrofit2.http.GET

interface SpellsApi {

    @GET("spells/")
    suspend fun getSpells(): LiveData<SpellListResponse>

}