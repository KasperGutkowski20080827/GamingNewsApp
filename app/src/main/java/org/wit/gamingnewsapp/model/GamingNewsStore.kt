package org.wit.gamingnewsapp.model

interface GamingNewsStore {
    fun findAll(): List<GamingNewsModel>
    fun create(gamingnews: GamingNewsModel)
    fun update(gamingnews: GamingNewsModel)
    fun delete(idToDelete: Long)
}