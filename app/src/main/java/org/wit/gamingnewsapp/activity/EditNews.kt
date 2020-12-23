package org.wit.gamingnewsapp.activity

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_deletenews.*
import kotlinx.android.synthetic.main.activity_editnews.*
import org.jetbrains.anko.toast
import org.wit.gamingnewsapp.R
import org.wit.gamingnewsapp.model.GamingNewsModel
import org.wit.gamingnewsapp.model.GamingNewsStore
import org.wit.gamingnewsapp.model.JSONStorage

class EditNews : AppCompatActivity() {

    var gamingnews = GamingNewsModel()
    lateinit var gaming: GamingNewsStore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editnews)

        gaming = JSONStorage(applicationContext)

        val editButton = findViewById<Button>(R.id.editButton)
        editButton.setOnClickListener{
            gamingnews.id = editIDnews.text.toString().toLong()
            gamingnews.title = editTitle.text.toString()
            gamingnews.description = editDescription.text.toString()
            gamingnews.bodyReport = editBody.text.toString()

            if(gamingnews.id === 0L){
                toast("Enter ID to edit a news report")
            }else
                gaming.update(gamingnews.copy())
            toast("News Updated")
        }

    }

}