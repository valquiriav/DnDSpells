package com.valquiria.dndspells.data.repository

import com.valquiria.dndspells.data.api.SpellsApi
import com.valquiria.dndspells.data.remote.response.SpellListResponse
import com.valquiria.dndspells.domain.repository.Repository
import io.reactivex.Single

class RepositoryImpl(
    private val spellsApi: SpellsApi
) : Repository {

    override fun loadSpells(): Single<SpellListResponse> = spellsApi.getSpells()

    override fun loadSpellDetails(index: String) = spellsApi.getSpell(index)
}