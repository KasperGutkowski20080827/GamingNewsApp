package org.wit.gamingnewsapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import org.wit.gamingnewsapp.R

class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        val addButton = findViewById<Button>(R.id.addButtonTab)
        addButton.setOnClickListener{
            val intent = Intent(this, AddNews::class.java)
            startActivity(intent)
        }

        val editButton = findViewById<Button>(R.id.editNewsTab)
        editButton.setOnClickListener{
            val intent = Intent(this, EditNews::class.java)
            startActivity(intent)
        }

        val listButton = findViewById<Button>(R.id.listNewsTab)
        listButton.setOnClickListener{
            val intent = Intent(this, ListNews::class.java)
            startActivity(intent)
        }

        val deleteButton = findViewById<Button>(R.id.deleteNewsTab)
        deleteButton.setOnClickListener{
            val intent = Intent(this, DeleteNews::class.java)
            startActivity(intent)
        }
    }
}