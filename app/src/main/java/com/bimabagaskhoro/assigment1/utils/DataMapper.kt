package com.bimabagaskhoro.assigment1.utils

import com.bimabagaskhoro.assigment1.data.source.local.entity.ItemGuestEntity
import com.bimabagaskhoro.assigment1.data.source.remote.response.DataItem
import com.bimabagaskhoro.assigment1.domain.model.ItemGuest

object DataMapper {
    fun mapResponsesToEntities(data: List<DataItem>): List<ItemGuestEntity> {
        val tourismList = ArrayList<ItemGuestEntity>()
        data.map {
            val guest = ItemGuestEntity(
                id = it.id,
                firstName = it.firstName,
                lastName = it.lastName,
                avatar = it.avatar,
                email = it.email
            )
            tourismList.add(guest)
        }
        return tourismList
    }

    fun mapEntitiesToDomain(input: List<ItemGuestEntity>): List<ItemGuest> =
        input.map {
            ItemGuest(
                id = it.id,
                firstName = it.firstName,
                lastName = it.lastName,
                avatar = it.avatar,
                email = it.email,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: ItemGuest) = ItemGuestEntity(
        id = input.id,
        firstName = input.firstName,
        lastName = input.lastName,
        avatar = input.avatar,
        email = input.email,
        isFavorite = input.isFavorite
    )
}