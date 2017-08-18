package com.sheypoor.tvmaze.base

import com.orm.SugarRecord

/**
 *  Created by Masoud Ashrafzadeh 2017/08/17.
 */
abstract class BaseModel : SugarRecord() {

    var isCached = false


}