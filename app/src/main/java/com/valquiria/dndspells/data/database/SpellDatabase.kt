package com.valquiria.dndspells.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.valquiria.dndspells.data.database.dao.SpellDao
import com.valquiria.dndspells.data.database.entity.SpellEntity

@Database(
    entities = [SpellEntity::class],
    version = 1,
    exportSchema = false
)
abstract class SpellDatabase : RoomDatabase() {
    abstract fun spellDao(): SpellDao
}