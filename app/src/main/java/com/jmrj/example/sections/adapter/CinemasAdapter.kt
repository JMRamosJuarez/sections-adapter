package com.jmrj.example.sections.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.jmrj.sections.adapter.SectionsAdapter
import com.squareup.picasso.Picasso

class CinemasAdapter(private val context: Context) :
    SectionsAdapter<Cinema, Movie, CinemasAdapter.CinemaViewHolder, CinemasAdapter.MovieViewHolder>() {

    companion object {
        const val CINEMA = 10
        const val MOVIE = 11
    }

    private val inflater: LayoutInflater by lazy { LayoutInflater.from(this.context) }

    override fun onBindHeader(headerViewHolder: CinemaViewHolder, header: Cinema) {
        headerViewHolder.titleTextView.text = header.name
        headerViewHolder.titleTextView.setOnClickListener {
            Toast.makeText(this.context, header.name, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onBindItem(itemViewHolder: MovieViewHolder, header: Cinema, item: Movie) {
        itemViewHolder.titleTextView.text = item.title
        Picasso
            .get()
            .load(item.posterUrl)
            .error(R.drawable.placeholder)
            .placeholder(R.drawable.placeholder)
            .into(itemViewHolder.movieImageView)
        itemViewHolder.movieImageView.setOnClickListener {
            Toast.makeText(this.context, "${header.name}, ${item.title}", Toast.LENGTH_SHORT).show()
        }
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

    class CinemaViewHolder(itemView: View) : SectionsAdapter.HeaderViewHolder(itemView) {
        val titleTextView: TextView = this.itemView.findViewById(R.id.title_text_view)
    }

    class MovieViewHolder(itemView: View) : SectionsAdapter.ItemViewHolder(itemView) {
        val movieImageView: ImageView = this.itemView.findViewById(R.id.movie_image_view)
        val titleTextView: TextView = this.itemView.findViewById(R.id.movie_title_text_view)
    }
}