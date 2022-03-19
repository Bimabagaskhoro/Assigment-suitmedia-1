package com.bimabagaskhoro.assigment1.data.source.remote.network

import com.bimabagaskhoro.assigment1.data.source.remote.response.ResponseItemGuest
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getAllGuest(): ResponseItemGuest
}