package org.wit.gamingnewsapp.activity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_view.view.*
import org.wit.gamingnewsapp.R
import org.wit.gamingnewsapp.model.GamingNewsModel

class gameNewsAdapter constructor(
        private var gamingNews: List<GamingNewsModel>
) : RecyclerView.Adapter<gameNewsAdapter.MainHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        return MainHolder(
                LayoutInflater.from(parent.context).inflate(
                        R.layout.card_view,
                        parent,
                        false
                )
        )
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val game = gamingNews[holder.adapterPosition]
        holder.bind(game)
    }

    override fun getItemCount(): Int = gamingNews.size

    class MainHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(gameNews: GamingNewsModel,  ) {
            itemView.gameTitle.text = gameNews.title
            itemView.description.text = gameNews.description
            itemView.bodyReport.text = gameNews.bodyReport
        }
    }
}