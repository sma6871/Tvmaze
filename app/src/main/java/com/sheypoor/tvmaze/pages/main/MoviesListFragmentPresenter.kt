package com.sheypoor.tvmaze.pages.main

import com.sheypoor.tvmaze.data.models.MovieModel
import com.sheypoor.tvmaze.data.repository.MoviesRepo
import io.reactivex.disposables.CompositeDisposable

class MoviesListFragmentPresenter(val view: MovieListContract.View) : MovieListContract.Presenter {

    val compositeDisposable = CompositeDisposable()

    init {

        view.setPresenter(this)
    }

    override fun openMoviesDetail(movieModel: MovieModel) {
        movieModel.image?.save()
        movieModel.rating?.save()
        MoviesRepo.saveCached(movieModel)
        view.showMovieDetail()
    }

    override fun start() {

        loadMovies(true)
    }

    /**
     * Loads movies by page number
     * @param clearData: clear list and load first page only if true, else, load next page
     *
     * */
    override fun loadMovies(clearData: Boolean) {
        view.setLoadingIndicator(true)


        if (clearData)
            MoviesRepo.lastLoadedPageNumber = 0

        compositeDisposable.add(
                MoviesRepo.loadMovies(MoviesRepo.lastLoadedPageNumber + 1).subscribe(
                        { result ->
                            run {
                                if (clearData)
                                    view.showMovies(result)
                                else
                                    view.showNextPage(result)
                                view.setLoadingIndicator(false)
                                MoviesRepo.lastLoadedPageNumber += 1
                            }
                        },
                        { error ->
                            run {
                                view.showError(error.localizedMessage)
                                view.setLoadingIndicator(false)
                            }
                        }

                )
        )
    }

    override fun stop() {
        compositeDisposable.clear()
    }
}