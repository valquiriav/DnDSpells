package com.valquiria.dndspells.domain.usecase

import com.valquiria.dndspells.data.remote.response.SpellItemResponse
import com.valquiria.dndspells.domain.model.SpellModel
import com.valquiria.dndspells.domain.repository.Repository
import io.reactivex.Single

class GetSpellDetailsUseCase(
    private val repository: Repository
) {
    fun getSpellDetails(index: String): Single<SpellModel> {
        return repository.loadSpellDetails(index)
            .map { it.toSpellModel() }
    }

    private fun SpellItemResponse.toSpellModel(): SpellModel {
        return SpellModel(
            spellIndex = index,
            spellName = name,
            spellDescription = description?.elementAt(0),
            spellLevel = spellLevel,
            spellSchool = spellSchool?.schoolName
        )
    }
}