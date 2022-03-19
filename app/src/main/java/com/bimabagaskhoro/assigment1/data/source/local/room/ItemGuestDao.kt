package com.bimabagaskhoro.assigment1.data.source.local.room

import androidx.room.*
import com.bimabagaskhoro.assigment1.data.source.local.entity.ItemGuestEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemGuestDao {
    @Query("SELECT * FROM item_guest")
    fun getAllTourism(): Flow<List<ItemGuestEntity>>

    @Query("SELECT * FROM item_guest where isFavorite = 1")
    fun getFavoriteTourism(): Flow<List<ItemGuestEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTourism(tourism: List<ItemGuestEntity>)

    @Update
    fun updateFavoriteTourism(tourism: ItemGuestEntity)
}