package com.bimabagaskhoro.assigment1.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item_guest")
data class ItemGuestEntity (
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "firstName")
    val firstName: String,

    @ColumnInfo(name = "lastName")
    val lastName: String,

    @ColumnInfo(name = "avatar")
    val avatar: String,

    @ColumnInfo(name = "email")
    val email: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)