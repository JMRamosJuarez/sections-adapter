package com.jmrj.example.sections.adapter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val adapter = CinemasAdapter(this)
        this.movies_recycler_view.adapter = adapter
        adapter.updateSections(this.generateItems(5, 10))
    }

    private fun generateItems(cinemas: Int, movies: Int): List<Cinema> {
        val result: MutableList<Cinema> = mutableListOf()

        for (i in 1..cinemas) {
            val cinema = Cinema("Cinema $i")
            val ms: MutableList<Movie> = mutableListOf()
            for (j in 1..movies) {
                val m =
                    Movie("Movie $j", "https://i.pinimg.com/originals/c0/df/c5/c0dfc52d8a19ebba5599e48251b16510.jpg")
                ms.add(m)
            }
            cinema.movies = ms
            result.add(cinema)
        }
        return result
    }
}
