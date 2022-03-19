package com.bimabagaskhoro.assigment1.data.source.remote

import android.util.Log
import com.bimabagaskhoro.assigment1.data.source.remote.network.ApiResponse
import com.bimabagaskhoro.assigment1.data.source.remote.network.ApiService
import com.bimabagaskhoro.assigment1.data.source.remote.response.DataItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    suspend fun getAllItemGuest(): Flow<ApiResponse<List<DataItem>>> {
        return flow {
            try {
                val response = apiService.getAllGuest()
                val dataArray = response.data
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.data))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}