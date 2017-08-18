package com.sheypoor.tvmaze.data.repository

import com.nevro.mydiet.base.BaseRepository
import com.sheypoor.tvmaze.app.di.DependencyInjector
import com.sheypoor.tvmaze.data.models.MovieModel
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Masoud Ashrafzadeh on 2017/08/18.
 *
 *
 */
object MoviesRepo : BaseRepository<MovieModel>(MovieModel::class.java) {

    var lastLoadedPageNumber = 0

    init {
        DependencyInjector.mainComponent?.inject(this)
    }

    /**
     * Load TvMaze shows by page number
     * @param pageNumber : movies page number to load
     * */
    fun loadMovies(pageNumber: Int): Flowable<List<MovieModel>> {

        lastLoadedPageNumber = pageNumber

        return apiService.loadMovies(pageNumber)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())

    }

}