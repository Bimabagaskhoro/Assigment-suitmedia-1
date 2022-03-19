package com.bimabagaskhoro.assigment1.domain.repository

import com.bimabagaskhoro.assigment1.data.Resource
import com.bimabagaskhoro.assigment1.domain.model.ItemGuest
import kotlinx.coroutines.flow.Flow

interface IItemGuestRepository {
    fun getAllItemGuest(): Flow<Resource<List<ItemGuest>>>
}