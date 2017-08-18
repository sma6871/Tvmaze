package com.sheypoor.tvmaze.pages.detail

import android.os.Build
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.widget.Toolbar
import android.text.Html
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import com.sheypoor.tvmaze.R
import com.sheypoor.tvmaze.base.BaseActivity
import com.sheypoor.tvmaze.data.models.MovieModel
import com.squareup.picasso.Picasso

class MovieDetailActivity : BaseActivity(), MovieDetailContract.View {


    private var mPresenter: MovieDetailContract.Presenter? = null

    @BindView(R.id.imgCover)
    lateinit var imgCover: ImageView

    @BindView(R.id.txtDateAndRate)
    lateinit var txtDateAndRate: TextView
    @BindView(R.id.txtDescription)
    lateinit var txtDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewReady(savedInstanceState: Bundle?) {
        super.onViewReady(savedInstanceState)


        val toolbar = findViewById(R.id.toolbar) as Toolbar

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Show Movie...", Snackbar.LENGTH_LONG).show()
        }

        MovieDetailPresenter(this).start()

    }

    override fun setPresenter(presenter: MovieDetailContract.Presenter) {
        mPresenter = presenter
    }

    override fun showMovieDetails(movieModel: MovieModel) {
        Picasso.with(this)
                .load(movieModel.image?.original)
                .fit().centerCrop()
                .into(imgCover)
        supportActionBar?.title = movieModel.name
        txtDateAndRate.text = String.format("%s • %d min • %.1f/10", movieModel.premiered, movieModel.runtime, movieModel.rating?.average)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            txtDescription.text = Html.fromHtml(movieModel.summary,Html.FROM_HTML_MODE_LEGACY)
        }
        else
            txtDescription.text = Html.fromHtml(movieModel.summary)
    }


    override fun getContentView() = R.layout.activity_movie_detail

    override fun resolveDependencies() {

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item!!.itemId.equals(android.R.id.home))
            finish()
        return true
    }

}
