package com.valquiria.dndspells.data.remote

import com.valquiria.dndspells.data.remote.response.Spell
import com.valquiria.dndspells.data.remote.response.SpellApiResponse
import com.valquiria.dndspells.domain.model.SpellInfoModel
import io.reactivex.Single
import retrofit2.http.GET

interface SpellsApi {

    @GET("spells/")
    fun getSpells(): Single<SpellApiResponse>

    @GET("spells/?name={index}")
    fun getSpell(index: String): Single<SpellInfoModel>

}