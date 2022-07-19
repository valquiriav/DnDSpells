package com.valquiria.dndspells.data.remote.response

data class SpellListResponse(
    val count: Int,
    val results: List<SpellItemResponse>
)