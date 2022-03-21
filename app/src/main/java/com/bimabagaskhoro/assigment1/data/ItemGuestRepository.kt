package com.bimabagaskhoro.assigment1.data

import com.bimabagaskhoro.assigment1.data.source.local.LocalDataSource
import com.bimabagaskhoro.assigment1.data.source.remote.RemoteDataSource
import com.bimabagaskhoro.assigment1.data.source.remote.network.ApiResponse
import com.bimabagaskhoro.assigment1.data.source.remote.response.DataItem
import com.bimabagaskhoro.assigment1.domain.model.ItemGuest
import com.bimabagaskhoro.assigment1.domain.repository.IItemGuestRepository
import com.bimabagaskhoro.assigment1.utils.AppExecutors
import com.bimabagaskhoro.assigment1.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ItemGuestRepository  @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IItemGuestRepository {

    override fun getAllItemGuest(): Flow<Resource<List<ItemGuest>>> =
        object : NetworkBoundResource<List<ItemGuest>, List<DataItem>>() {
            override fun loadFromDB(): Flow<List<ItemGuest>> {
                return localDataSource.getAllTourism().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<ItemGuest>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<DataItem>>> =
                remoteDataSource.getAllItemGuest()

            override suspend fun saveCallResult(data: List<DataItem>) {
                val tourismList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertTourism(tourismList)
            }
        }.asFlow()
}