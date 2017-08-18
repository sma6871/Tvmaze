package com.sheypoor.tvmaze.pages.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.sheypoor.tvmaze.R
import com.sheypoor.tvmaze.data.models.MovieModel
import com.squareup.picasso.Picasso

/**
 * Created by Masoud Ashrafzadeh on 2017/08/18.
 * Adapter for list of movies
 */
class MoviesListAdapter(var listMovies: MutableList<MovieModel>) : RecyclerView.Adapter<MoviesListAdapter.ViewHolder>() {

    var context: Context? = null
    var listener: RecyclerViewClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.grid_list_item_layout, parent, false)
        context = parent?.context
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val movieItem = listMovies[position]

        Picasso.with(context)
                .load(movieItem.image?.medium)
                .into(holder?.imgThumbnail)

        holder?.txtTitle?.text = movieItem.name
        holder?.itemView?.setOnClickListener({
            listener?.onClick(movieItem)
        })

    }

    override fun getItemCount() = listMovies.size


    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

        @BindView(R.id.imgThumbnail)
        lateinit var imgThumbnail: ImageView

        @BindView(R.id.item_movie_title)
        lateinit var txtTitle: TextView

        init {
            ButterKnife.bind(this, itemview)
        }

    }

    interface RecyclerViewClickListener {
        fun onClick(movieModel: MovieModel)
    }

    fun append(movies: List<MovieModel>) {
        val lastPosition = listMovies.size - 1
        listMovies.addAll(movies)
        notifyItemRangeInserted(lastPosition, movies.size)
    }
}