package org.wit.gamingnewsapp.activity

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_deletenews.*
import org.jetbrains.anko.toast
import org.wit.gamingnewsapp.R
import org.wit.gamingnewsapp.model.GamingNewsModel
import org.wit.gamingnewsapp.model.GamingNewsStore
import org.wit.gamingnewsapp.model.JSONStorage

class DeleteNews : AppCompatActivity() {

    var gamingnews = GamingNewsModel()
    lateinit var gaming: GamingNewsStore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deletenews)

        gaming = JSONStorage(applicationContext)

        val deleteButton = findViewById<Button>(R.id.newsDeleteButton)
        deleteButton.setOnClickListener{
            gamingnews.id = idDelete.text.toString().toLong()

            if(gamingnews.id === 0L){
                toast("Enter ID to delete a gaming news report")
            }else
                gaming.delete(gamingnews.id)
                toast("Game news Report Deleted")
        }
    }
}