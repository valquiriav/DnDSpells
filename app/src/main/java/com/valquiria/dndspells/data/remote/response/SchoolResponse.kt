package com.valquiria.dndspells.data.remote.response

import com.google.gson.annotations.SerializedName

data class SchoolResponse(

    @field:SerializedName("name")
    val schoolName: String? = null

)