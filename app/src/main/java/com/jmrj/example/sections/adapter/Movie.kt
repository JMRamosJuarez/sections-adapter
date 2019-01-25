package com.jmrj.example.sections.adapter

import com.jmrj.sections.adapter.Section

class Movie(val title: String, val posterUrl: String) : Section.Item {

    override fun getItemViewType(): Int = CinemasAdapter.MOVIE
}