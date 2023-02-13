package com.valquiria.dndspells.data.remote.response

import com.google.gson.annotations.SerializedName

data class SpellItemResponse(

    @field:SerializedName("index")
    val index: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("desc")
    val description: List<String>? = null,

    @field:SerializedName("level")
    val spellLevel: Int? = null,

    @field:SerializedName("school")
    val spellSchool: SchoolResponse? = null
)