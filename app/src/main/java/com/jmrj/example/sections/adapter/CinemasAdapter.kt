package com.jmrj.example.sections.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jmrj.sections.adapter.SectionsAdapter

class CinemasAdapter(private val context: Context) :
    SectionsAdapter<Cinema, Movie, CinemasAdapter.CinemaViewHolder, CinemasAdapter.MovieViewHolder>() {

    companion object {
        const val CINEMA = 10
        const val MOVIE = 11
    }

    private val inflater: LayoutInflater by lazy { LayoutInflater.from(this.context) }

    override fun onBindHeader(headerViewHolder: CinemaViewHolder?, header: Cinema) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindItem(itemViewHolder: MovieViewHolder?, item: Movie) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SectionViewHolder<CinemaViewHolder, MovieViewHolder> {
        return if (viewType == CINEMA) {
            SectionViewHolder(CinemaViewHolder(this.inflater.inflate(R.layout.cinema_layout_item, parent, false)))
        } else {
            SectionViewHolder(MovieViewHolder(this.inflater.inflate(R.layout.movie_layout_item, parent, false)))
        }
    }

    class CinemaViewHolder(itemView: View) : SectionsAdapter.HeaderViewHolder(itemView)

    class MovieViewHolder(itemView: View) : SectionsAdapter.ItemViewHolder(itemView)
}