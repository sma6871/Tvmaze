package com.sheypoor.tvmaze.data.models

import com.sheypoor.tvmaze.base.BaseModel

data class Network(
	val country: Country? = null,
	val name: String? = null
): BaseModel()
