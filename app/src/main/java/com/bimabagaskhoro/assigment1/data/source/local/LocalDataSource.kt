package com.bimabagaskhoro.assigment1.data.source.local

import com.bimabagaskhoro.assigment1.data.source.local.entity.ItemGuestEntity
import com.bimabagaskhoro.assigment1.data.source.local.room.ItemGuestDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val itemGuestDao: ItemGuestDao) {

    fun getAllTourism(): Flow<List<ItemGuestEntity>> = itemGuestDao.getAllTourism()

    fun getFavoriteTourism(): Flow<List<ItemGuestEntity>> = itemGuestDao.getFavoriteTourism()

    suspend fun insertTourism(tourismList: List<ItemGuestEntity>) = itemGuestDao.insertTourism(tourismList)

    fun setFavoriteTourism(tourism: ItemGuestEntity, newState: Boolean) {
        tourism.isFavorite = newState
        itemGuestDao.updateFavoriteTourism(tourism)
    }
}