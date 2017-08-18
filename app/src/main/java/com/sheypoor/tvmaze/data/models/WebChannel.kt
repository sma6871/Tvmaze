package com.sheypoor.tvmaze.data.models

import com.sheypoor.tvmaze.base.BaseModel

data class WebChannel(
	val country: Country? = null,
	val name: String? = null
): BaseModel()
