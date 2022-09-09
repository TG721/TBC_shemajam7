package com.example.android_tbc_homework_14.domain

import com.example.android_tbc_homework_14.data.model.Items
import retrofit2.Response

interface MyRepository {
    suspend fun doNetworkCall(): Response<Items>
}