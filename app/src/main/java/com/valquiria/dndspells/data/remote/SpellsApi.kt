package com.valquiria.dndspells.data.remote

import com.valquiria.dndspells.data.remote.response.SpellApiResponse
import io.reactivex.Single
import retrofit2.http.GET

interface SpellsApi {

    @GET("spells/")
    fun getSpells(): Single<SpellApiResponse>

}