package com.valquiria.dndspells.data.repository

import com.valquiria.dndspells.data.database.dao.SpellDao
import com.valquiria.dndspells.data.database.entity.SpellEntity
import com.valquiria.dndspells.data.remote.SpellsApi

class SpellRepositoryImpl(
    private val spellDao: SpellDao,
    private val spellsApi: SpellsApi
    ) : SpellRepository {

    override suspend fun loadSpells(): MutableList<SpellEntity> {

        val apiSpellList = spellsApi.getSpells()

        apiSpellList.map { spellResponse ->

            val spellEntity = SpellEntity(
                id = spellResponse.index,
                spellName = spellResponse.name
            )

            spellDao.save(spellEntity)
        }

        return spellDao.getAll()

    }

}