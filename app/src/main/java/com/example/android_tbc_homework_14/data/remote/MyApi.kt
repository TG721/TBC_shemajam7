package com.example.android_tbc_homework_14.data.remote

import com.example.android_tbc_homework_14.data.model.Items
import retrofit2.Response
import retrofit2.http.GET

interface MyApi {
    @GET("4167a598-b68c-420f-b6e1-fef68b89a10d")
    suspend fun doNetworkCall(): Response<Items>

}