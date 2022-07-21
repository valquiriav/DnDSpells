package com.valquiria.dndspells.data.repository

import com.valquiria.dndspells.data.database.dao.SpellDao
import com.valquiria.dndspells.data.database.entity.SpellEntity
import com.valquiria.dndspells.data.remote.SpellsApi

class SpellRepositoryImpl(
    private val spellDao: SpellDao,
    private val spellsApi: SpellsApi
    ) : SpellRepository {

    override fun loadSpells() = spellsApi.getSpells()

}