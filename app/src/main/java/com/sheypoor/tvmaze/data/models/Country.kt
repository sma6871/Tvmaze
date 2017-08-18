package com.sheypoor.tvmaze.data.models

import com.sheypoor.tvmaze.base.BaseModel

data class Country(
	val code: String? = null,
	val timezone: String? = null,
	val name: String? = null
): BaseModel()
