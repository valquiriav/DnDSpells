package com.valquiria.dndspells.data.repository

import com.valquiria.dndspells.data.database.entity.SpellEntity
import com.valquiria.dndspells.data.remote.response.SpellResponse
import io.reactivex.Single

interface SpellRepository {

    fun loadSpells(): Single<SpellResponse>
}