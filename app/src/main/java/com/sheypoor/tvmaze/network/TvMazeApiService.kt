package com.sheypoor.tvmaze.network

import com.sheypoor.tvmaze.data.models.MovieModel
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *  Created by Masoud Ashrafzadeh on 2017/08/17.
 */
interface TvMazeApiService {

    @GET("shows")
    fun loadMovies(@Query("page") pageNumber: Int): Flowable<List<MovieModel>>

}