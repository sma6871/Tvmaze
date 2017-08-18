package com.sheypoor.tvmaze.pages.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import com.sheypoor.tvmaze.R
import com.sheypoor.tvmaze.data.models.MovieModel
import com.squareup.picasso.Picasso

/**
 * Created by Masoud Ashrafzadeh on 2017/08/18.
 * Adapter for list of movies
 */
class MoviesListAdapter(var listMovies: List<MovieModel>) : RecyclerView.Adapter<MoviesListAdapter.ViewHolder>() {

    var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.grid_list_item_layout, parent, false)
        context = parent?.context
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val movieItem = listMovies.get(position)

        Picasso.with(context)
                .load(movieItem.image?.medium)
                .centerCrop()
                .into(holder?.imgThumbnail)

        holder?.txtTitle?.text = movieItem.name

    }

    override fun getItemCount(): Int {
        return listMovies.size
    }


    class ViewHolder(val itemview: View) : RecyclerView.ViewHolder(itemview) {

        @BindView(R.id.imgThumbnail)
        lateinit var imgThumbnail: ImageView
        @BindView(R.id.item_movie_title)
        lateinit var txtTitle: TextView
    }
}