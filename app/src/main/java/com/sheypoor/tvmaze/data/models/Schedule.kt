package com.sheypoor.tvmaze.data.models

import com.sheypoor.tvmaze.base.BaseModel

data class Schedule(
	val days: List<String?>? = null,
	val time: String? = null
): BaseModel()
