package org.wit.gamingnewsapp.activity

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_addnews.*
import org.wit.gamingnewsapp.R
import org.wit.gamingnewsapp.model.GamingNewsModel
import org.wit.gamingnewsapp.model.GamingNewsStore
import org.wit.gamingnewsapp.model.JSONStorage
import org.jetbrains.anko.toast

class AddNews : AppCompatActivity() {

    var gamingnews = GamingNewsModel()
    lateinit var gaming: GamingNewsStore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addnews)

        gaming = JSONStorage(applicationContext)

        val addButton = findViewById<Button>(R.id.addButton)
        addButton.setOnClickListener{
            gamingnews.title = NewsTitle.text.toString()
            gamingnews.author = NewsAuthor.text.toString()
            gamingnews.description = NewsDescription.text.toString()
            gamingnews.bodyReport = NewsBody.text.toString()

            if(gamingnews.title.isEmpty()){
                toast("Please Enter the title to procceed")
            }
            else if(gamingnews.author.isEmpty()){
                toast("Enter authors name to proceed")
            }
            else if(gamingnews.bodyReport.isEmpty()){
                toast("Enter the article to add a news report")
            }
            else{
                gaming.create(gamingnews.copy())
                toast("Gaming news successfully Added")
            }
        }
    }
}

