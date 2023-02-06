package com.valquiria.dndspells.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.valquiria.dndspells.data.local.dao.SpellDao
import com.valquiria.dndspells.data.local.entity.SpellEntity

@Database(
    entities = [SpellEntity::class],
    version = 1,
    exportSchema = false
)
abstract class SpellDatabase : RoomDatabase() {
    abstract fun spellDao(): SpellDao
}