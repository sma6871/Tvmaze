package com.sheypoor.tvmaze.pages.detail

import com.sheypoor.tvmaze.base.BasePresenter
import com.sheypoor.tvmaze.base.BaseView
import com.sheypoor.tvmaze.data.models.MovieModel

/**
 * Created by Masoud Ashrafzadeh on 2017/08/18.
 */
interface MovieDetailContract {
    interface View : BaseView<Presenter>
    {
        fun showMovieDetails(movieMocel:MovieModel)
    }
    interface Presenter:BasePresenter
    {
        fun loadMovie()
    }
}