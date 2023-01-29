package com.valquiria.dndspells.domain.usecase

import com.valquiria.dndspells.data.repository.SpellRepository
import com.valquiria.dndspells.domain.model.SpellInfoModel
import io.reactivex.Single

class GetSpellDetailsUseCase(
    private val repository: SpellRepository
) {
    fun getSpellDetails(index: String): Single<SpellInfoModel> {
        return repository.loadSpellDetails(index)
    }
}