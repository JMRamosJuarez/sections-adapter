package com.jmrj.example.sections.adapter

import com.jmrj.sections.adapter.Section

class Movie : Section.Item {

    override fun getItemViewType(): Int = CinemasAdapter.MOVIE
}