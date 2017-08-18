package com.sheypoor.tvmaze.pages.main

import com.sheypoor.tvmaze.base.BasePresenter
import com.sheypoor.tvmaze.base.BaseView
import com.sheypoor.tvmaze.data.models.MovieModel

/**
 * Created by Masoud Ashrafzadeh on 2017/08/17.
 */
interface MovieListContract {

    interface View : BaseView<Presenter> {
        fun showMovies(movies: List<MovieModel>)
        fun setLoadingIndicator(active: Boolean)
        fun showMovieDetail(movieId: Int?)
        fun showNextPage(movies: List<MovieModel>)
    }

    interface Presenter : BasePresenter {
        fun loadMovies(clearData:Boolean)
        fun openMoviesDetail(movieModel: MovieModel)
    }

}