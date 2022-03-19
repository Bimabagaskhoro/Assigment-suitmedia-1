package com.bimabagaskhoro.assigment1.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemGuest (
    val id: Int,
    val firstName: String,
    val lastName: String,
    val avatar: String,
    val email: String,
    val isFavorite: Boolean
): Parcelable