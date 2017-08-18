package com.sheypoor.tvmaze.pages.detail

import com.sheypoor.tvmaze.data.repository.MoviesRepo

/**
 * Created by Masoud Ashrafzadeh on 2017/08/18.
 */
class MovieDetailPresenter(val view: MovieDetailContract.View):MovieDetailContract.Presenter {


    override fun start() {
        loadMovie()

    }

    override fun stop() {

    }

    override fun loadMovie() {
        view.showMovieDetails(MoviesRepo.loadCached())
    }
}