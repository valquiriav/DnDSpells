package com.valquiria.dndspells.domain

import com.valquiria.dndspells.data.database.entity.SpellEntity
import com.valquiria.dndspells.data.repository.SpellRepository

class GetSpellListUseCase(
    private val repository: SpellRepository
) {
    suspend fun execute(): MutableList<SpellEntity> =
        repository.loadSpells()
}