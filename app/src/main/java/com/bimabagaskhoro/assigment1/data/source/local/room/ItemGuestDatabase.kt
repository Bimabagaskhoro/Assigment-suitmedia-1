package com.bimabagaskhoro.assigment1.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bimabagaskhoro.assigment1.data.source.local.entity.ItemGuestEntity

@Database(entities = [ItemGuestEntity::class], version = 1, exportSchema = false)
abstract class ItemGuestDatabase : RoomDatabase(){
    abstract fun tourismDao(): ItemGuestDao
}