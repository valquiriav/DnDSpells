package com.valquiria.dndspells.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.valquiria.dndspells.data.local.entity.SpellEntity

@Dao
interface SpellDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(spell: SpellEntity)

    @Query("SELECT * FROM table_spell")
    fun getAll(): MutableList<SpellEntity>

    @Query("SELECT * FROM table_spell WHERE id = :id")
    fun getSpell(id: String): SpellEntity
}