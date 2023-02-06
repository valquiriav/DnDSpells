package com.valquiria.dndspells.domain.repository

import com.valquiria.dndspells.data.remote.response.SpellItemResponse
import com.valquiria.dndspells.data.remote.response.SpellListResponse
import io.reactivex.Single

interface Repository {

    fun loadSpells(): Single<SpellListResponse>
    fun loadSpellDetails(index: String): Single<SpellItemResponse>
}