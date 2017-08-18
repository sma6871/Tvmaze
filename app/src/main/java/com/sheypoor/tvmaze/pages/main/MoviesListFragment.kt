package com.sheypoor.tvmaze.pages.main


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import com.sheypoor.tvmaze.R
import com.sheypoor.tvmaze.base.BaseFragment
import com.sheypoor.tvmaze.data.models.MovieModel
import com.sheypoor.tvmaze.pages.detail.MovieDetailActivity
import com.sheypoor.tvmaze.utils.RecyclerInsetsDecoration

/**
 * A simple [Fragment] subclass.
 * Use the [MoviesListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MoviesListFragment : BaseFragment(), MovieListContract.View, MoviesListAdapter.RecyclerViewClickListener {
    var mPresenter: MovieListContract.Presenter? = null

    @BindView(R.id.listMovies)
    lateinit var listMovies: RecyclerView

    @BindView(R.id.progressBarData)
    lateinit var progressBar: ProgressBar


    var adapter: MoviesListAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onResume() {
        super.onResume()

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater!!.inflate(R.layout.fragment_main, container, false)
        ButterKnife.bind(this, view)
        mPresenter?.start()
        return view
    }

    override fun showMovies(movies: List<MovieModel>) {
        val layoutManager = GridLayoutManager(context, 2)
        adapter = MoviesListAdapter(movies as MutableList<MovieModel>)
        adapter?.listener = this
        listMovies.layoutManager = layoutManager
        listMovies.addItemDecoration(RecyclerInsetsDecoration(activity))
        var loading = true
        var pastVisiblesItems: Int
        var visibleItemCount: Int
        var totalItemCount: Int
        listMovies.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                if (dy > 0)
                //check for scroll down
                {
                    visibleItemCount = layoutManager.childCount
                    totalItemCount = layoutManager.itemCount
                    pastVisiblesItems = layoutManager.findFirstVisibleItemPosition()

                    if (loading) {
                        if (visibleItemCount + pastVisiblesItems >= totalItemCount) {
                            loading = false
                            mPresenter?.loadMovies(false)
                        }
                    }
                }
            }
        });
        listMovies.adapter = adapter


    }

    override fun onClick(movieModel: MovieModel) {
        mPresenter?.openMoviesDetail(movieModel)
    }

    override fun showNextPage(movies: List<MovieModel>) {
        adapter?.append(movies)
    }


    override fun setLoadingIndicator(active: Boolean) {
        progressBar.isIndeterminate = true
        progressBar.visibility = when (active) {true -> View.VISIBLE
            false -> View.GONE
        }

    }

    override fun showError(message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    override fun showMovieDetail() {
        val intent = Intent(context, MovieDetailActivity::class.java)
        activity.startActivity(intent)

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
            return MoviesListFragment()
        }
    }
}
