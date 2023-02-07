package com.valquiria.dndspells.domain.usecase

import com.valquiria.dndspells.data.remote.response.SpellListResponse
import com.valquiria.dndspells.domain.model.SpellModel
import com.valquiria.dndspells.domain.repository.Repository
import io.reactivex.Single

class GetSpellListUseCase(
    private val repository: Repository
) {
    fun getSpells(): Single<List<SpellModel>?> =
        repository.loadSpells()
            .map { it.toSpellModel() }

    private fun SpellListResponse.toSpellModel(): List<SpellModel> {
        val newList = arrayListOf<SpellModel>()
        spells?.forEach { spell ->
            newList.add(
                SpellModel(
                    spellIndex = spell.index,
                    spellName = spell.name,
                    spellDescription = spell.description?.elementAt(0)
                )
            )
        }
        return newList
    }
}