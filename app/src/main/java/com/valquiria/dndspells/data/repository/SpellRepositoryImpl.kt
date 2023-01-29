package com.valquiria.dndspells.data.repository

import com.valquiria.dndspells.data.remote.SpellsApi

class SpellRepositoryImpl(
    private val spellsApi: SpellsApi
) : SpellRepository {

    override fun loadSpells() = spellsApi.getSpells()
        .map { it.results }

    override fun loadSpellDetails(index: String) = spellsApi.getSpell(index)
}