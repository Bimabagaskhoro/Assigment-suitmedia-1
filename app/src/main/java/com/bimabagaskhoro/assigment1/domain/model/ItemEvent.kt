package com.bimabagaskhoro.assigment1.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemEvent(
    val id: Int,
    var name: String,
    val image: Int,
    val date: String
) : Parcelable
