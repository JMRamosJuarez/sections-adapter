package com.jmrj.example.sections.adapter

import com.jmrj.sections.adapter.Section

class Cinema : Section<Movie> {

    override fun getHeaderViewType(): Int = CinemasAdapter.CINEMA

    override fun getItems(): List<Movie> = emptyList()
}