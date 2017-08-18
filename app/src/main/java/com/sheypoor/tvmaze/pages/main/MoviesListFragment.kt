package com.sheypoor.tvmaze.pages.main


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import com.sheypoor.tvmaze.R
import com.sheypoor.tvmaze.base.BaseFragment
import com.sheypoor.tvmaze.data.models.MovieModel

/**
 * A simple [Fragment] subclass.
 * Use the [MoviesListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MoviesListFragment : BaseFragment(), MovieListContract.View {

    var mPresenter: MovieListContract.Presenter? = null

    @BindView(R.id.listMovies)
    lateinit var listMovies: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onResume() {
        super.onResume()
        mPresenter?.start()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater!!.inflate(R.layout.fragment_main, container, false)
        ButterKnife.bind(view, activity)
        return view
    }

    override fun showMovies(movies: List<MovieModel>) {
        val layoutManager = GridLayoutManager(context, 2)
        val adapter = MoviesListAdapter(movies)
        listMovies.layoutManager = layoutManager
        listMovies.adapter = adapter


    }

    override fun showNextPage(movies: List<MovieModel>) {

    }

    override fun setLoadingIndicator(active: Boolean) {

    }

    override fun showMovieDetail(movieId: Int?) {

    }

    override fun setPresenter(presenter: MovieListContract.Presenter) {
        mPresenter = presenter
    }

    companion object {

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.

         * @return A new instance of fragment MainFragment.
         */
        fun newInstance(): MoviesListFragment {
            val fragment = MoviesListFragment()

            return fragment
        }
    }
}
