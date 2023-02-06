package com.valquiria.dndspells.presentation.ui.spellListScreen

import com.valquiria.dndspells.data.remote.response.SpellItemResponse

object Stub {

    fun getSpells() = listOf(
        SpellItemResponse("name", "123"),
        SpellItemResponse("name", "123")
    )
}