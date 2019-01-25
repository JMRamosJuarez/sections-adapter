package com.jmrj.sections.adapter

interface Section<out I : Section.Item> {

    fun getHeaderViewType(): Int

    fun getItems(): List<I>

    interface Item {

        fun getItemViewType(): Int
    }
}