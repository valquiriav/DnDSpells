package com.valquiria.dndspells.domain

import com.valquiria.dndspells.data.remote.response.Spell
import com.valquiria.dndspells.data.repository.SpellRepository
import io.reactivex.Single

class GetSpellListUseCase(
    private val repository: SpellRepository
) {
    fun getSpells(): Single<List<Spell>?> = repository.loadSpells()
}