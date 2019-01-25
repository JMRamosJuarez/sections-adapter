package com.jmrj.sections.adapter

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class SectionsAdapter<H : Section<I>, I : Section.Item, HV : SectionsAdapter.HeaderViewHolder, IV : SectionsAdapter.ItemViewHolder> :
    RecyclerView.Adapter<SectionsAdapter.SectionViewHolder<HV, IV>>() {

    private val _sections: MutableList<H> = mutableListOf()

    val sections: List<H>
        get() = this._sections

    private var viewTypes: MutableList<Int> = mutableListOf()

    private var headerPositions: MutableList<Int> = mutableListOf()

    private var itemsPositions: MutableList<Int> = mutableListOf()

    abstract fun onBindHeader(headerViewHolder: HV?, header: H)

    abstract fun onBindItem(itemViewHolder: IV?, item: I)

    override fun getItemCount(): Int {
        this.viewTypes = mutableListOf()
        this.headerPositions = mutableListOf()
        this.itemsPositions = mutableListOf()
        var count = 0
        for (i in sections.indices) {
            count++
            val section = this.sections[i]
            val items = section.getItems()
            this.viewTypes.add(section.getHeaderViewType())
            this.headerPositions.add(i)
            this.itemsPositions.add(i)
            for (j in items.indices) {
                count++
                val item = items[j]
                this.viewTypes.add(item.getItemViewType())
                this.headerPositions.add(i)
                this.itemsPositions.add(j)
            }
        }
        return count
    }

    override fun getItemViewType(position: Int): Int {
        return this.viewTypes[position]
    }

    override fun onBindViewHolder(holder: SectionViewHolder<HV, IV>, position: Int) {
        if (holder.headerViewHolder != null) {
            val section = this._sections[this.headerPositions[position]]
            this.onBindHeader(holder.headerViewHolder, section)
        } else {
            val section = this._sections[this.headerPositions[position]]
            this.onBindItem(holder.itemViewHolder, section.getItems()[this.itemsPositions[position]])
        }
    }

    class SectionViewHolder<HV : HeaderViewHolder, IV : ItemViewHolder> : RecyclerView.ViewHolder {

        var headerViewHolder: HV? = null
        var itemViewHolder: IV? = null

        constructor(headerViewHolder: HV) : super(headerViewHolder.itemView) {
            this.headerViewHolder = headerViewHolder
        }

        constructor(itemViewHolder: IV) : super(itemViewHolder.itemView) {
            this.itemViewHolder = itemViewHolder
        }
    }

    open class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    open class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    fun updateSections(sections: List<H>) {
        this._sections.clear()
        this._sections.addAll(sections)
        this.notifyDataSetChanged()
    }
}