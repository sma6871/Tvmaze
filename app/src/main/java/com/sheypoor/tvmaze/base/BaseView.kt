package com.sheypoor.tvmaze.base

/**
 *  Created by Masoud Ashrafzadeh 2017/08/17.
 */
interface BaseView<in T : BasePresenter> {
    fun setPresenter(presenter:T):Unit
}