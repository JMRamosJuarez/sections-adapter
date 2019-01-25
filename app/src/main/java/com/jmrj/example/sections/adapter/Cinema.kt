package com.jmrj.example.sections.adapter

import com.jmrj.sections.adapter.Section

class Cinema(val name: String) : Section<Movie> {

    var movies: List<Movie> = emptyList()

    override fun getHeaderViewType(): Int = CinemasAdapter.CINEMA

    override fun getItems(): List<Movie> = this.movies
}