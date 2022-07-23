package com.valquiria.dndspells.data.repository

import com.valquiria.dndspells.data.remote.response.Spell
import io.reactivex.Single

interface SpellRepository {

    fun loadSpells(): Single<List<Spell>?>
}