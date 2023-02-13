package com.valquiria.dndspells.domain.model

data class SpellModel(
    val spellIndex: String?,
    val spellName: String?,
    val spellDescription: String?,
    val spellLevel: Int?,
    val spellSchool: String?
)