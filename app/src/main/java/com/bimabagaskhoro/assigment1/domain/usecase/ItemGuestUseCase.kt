package com.bimabagaskhoro.assigment1.domain.usecase

import com.bimabagaskhoro.assigment1.data.Resource
import com.bimabagaskhoro.assigment1.domain.model.ItemGuest
import kotlinx.coroutines.flow.Flow

interface ItemGuestUseCase {
    fun getAllItemGuest(): Flow<Resource<List<ItemGuest>>>
}