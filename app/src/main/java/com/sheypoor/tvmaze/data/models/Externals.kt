package com.sheypoor.tvmaze.data.models

import com.sheypoor.tvmaze.base.BaseModel

data class Externals(
	val thetvdb: Int? = null,
	val imdb: String? = null,
	val tvrage: Int? = null
): BaseModel()
