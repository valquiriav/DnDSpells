package com.valquiria.dndspells.data.repository

import com.valquiria.dndspells.data.database.entity.SpellEntity

interface SpellRepository {

    suspend fun loadSpells(): MutableList<SpellEntity>
}