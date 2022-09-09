package com.example.android_tbc_homework_14.data.repository

import com.example.android_tbc_homework_14.data.model.Items
import com.example.android_tbc_homework_14.data.remote.MyApi
import com.example.android_tbc_homework_14.domain.MyRepository
import retrofit2.Response

class MyRepositoryImpl(
    private val api: MyApi
) : MyRepository {
    override suspend fun doNetworkCall(): Response<Items> {
        TODO("Not yet implemented")
    }

}