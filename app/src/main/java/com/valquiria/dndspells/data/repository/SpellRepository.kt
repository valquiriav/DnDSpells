package com.valquiria.dndspells.data.repository

import com.valquiria.dndspells.data.remote.response.Spell
import com.valquiria.dndspells.domain.model.SpellInfoModel
import io.reactivex.Single

interface SpellRepository {

    fun loadSpells(): Single<List<Spell>?>
    fun loadSpellDetails(index: String): Single<SpellInfoModel>
}