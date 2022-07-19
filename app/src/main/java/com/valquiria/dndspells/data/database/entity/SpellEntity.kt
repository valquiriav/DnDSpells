package com.valquiria.dndspells.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_spell")
data class SpellEntity(
    @PrimaryKey
    val id: String,
    val spellName: String
)