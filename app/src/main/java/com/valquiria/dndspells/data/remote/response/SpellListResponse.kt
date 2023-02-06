package com.valquiria.dndspells.data.remote.response

import com.google.gson.annotations.SerializedName

data class SpellListResponse(

    @field:SerializedName("results")
    val spells: List<SpellItemResponse>? = null
)