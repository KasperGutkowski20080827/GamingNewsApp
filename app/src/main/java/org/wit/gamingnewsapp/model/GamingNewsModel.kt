package org.wit.gamingnewsapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GamingNewsModel (
    var id:  Long = 0,
    var title: String = "",
    var description: String = "",
    var bodyReport: String = "") : Parcelable