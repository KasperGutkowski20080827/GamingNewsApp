package org.wit.gamingnewsapp.model


import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import org.wit.gamingnewsapp.read
import org.wit.gamingnewsapp.write

import java.util.*

val JSON_FILE = "GamingNews.json"
val gsonBuilder = GsonBuilder().setPrettyPrinting().create()
val listType = object : TypeToken<java.util.ArrayList<GamingNewsModel>>() {}.type

fun generateRandomId(): Long {
    return Random().nextLong()
}

class JSONStorage : GamingNewsStore {

    val context: Context
    var gamingNews = mutableListOf<GamingNewsModel>()

    constructor (context: Context) {
        this.context = context
        if (org.wit.gamingnewsapp.exists(context, JSON_FILE)) {
            deserialize()
        }
    }

    override fun findAll(): MutableList<GamingNewsModel> {
        return gamingNews
    }

    override fun create(gamingnews: GamingNewsModel) {
        gamingnews.id = generateRandomId()
        gamingNews.add(gamingnews)
        serialize()
    }


    override fun update(gamingnews: GamingNewsModel) {
        // todo
    }

    private fun serialize() {
        val jsonString = gsonBuilder.toJson(gamingNews, listType)
        write(context, JSON_FILE, jsonString)
    }

    private fun deserialize() {
        val jsonString = read(context, JSON_FILE)
        gamingNews = Gson().fromJson(jsonString, listType)
    }
}
