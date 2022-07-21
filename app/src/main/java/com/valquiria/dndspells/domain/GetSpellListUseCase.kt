package com.valquiria.dndspells.domain

import com.valquiria.dndspells.data.database.entity.SpellEntity
import com.valquiria.dndspells.data.remote.response.SpellResponse
import com.valquiria.dndspells.data.repository.SpellRepository
import io.reactivex.Single

class GetSpellListUseCase(
    private val repository: SpellRepository
) {
    fun execute(): Single<SpellResponse> = repository.loadSpells()
}