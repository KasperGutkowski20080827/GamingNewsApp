package org.wit.gamingnewsapp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_listnews.*
import org.wit.gamingnewsapp.R
import org.wit.gamingnewsapp.model.GamingNewsModel
import org.wit.gamingnewsapp.model.GamingNewsStore
import org.wit.gamingnewsapp.model.JSONStorage

class ListNews : AppCompatActivity() {

    var gamingnews = GamingNewsModel()
    lateinit var gaming: GamingNewsStore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listnews)

        gaming = JSONStorage(applicationContext)

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        loadGameNews()
    }

    private fun loadGameNews() {
        showGameNews(gaming.findAll())
    }

    fun showGameNews (gamingNews: List<GamingNewsModel>) {
        recyclerView.adapter = gameNewsAdapter(gamingNews)
        recyclerView.adapter?.notifyDataSetChanged()
    }
}