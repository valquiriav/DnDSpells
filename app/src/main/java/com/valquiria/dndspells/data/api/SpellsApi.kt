package com.valquiria.dndspells.data.api

import com.valquiria.dndspells.data.remote.response.SpellItemResponse
import com.valquiria.dndspells.data.remote.response.SpellListResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface SpellsApi {

    @GET("spells/")
    fun getSpells(): Single<SpellListResponse>

    @GET("spells/{name}")
    fun getSpell(@Path("name") index: String): Single<SpellItemResponse>

}