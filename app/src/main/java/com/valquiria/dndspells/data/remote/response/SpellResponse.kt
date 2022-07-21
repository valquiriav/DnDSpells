package com.valquiria.dndspells.data.remote.response

import com.google.gson.annotations.SerializedName

data class SpellResponse(

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("results")
	val results: List<ResultsItem?>? = null
)

data class ResultsItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("index")
	val index: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)
