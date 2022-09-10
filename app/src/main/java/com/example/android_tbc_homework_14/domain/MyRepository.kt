package com.example.android_tbc_homework_14.domain

import com.example.android_tbc_homework_14.data.model.Items
import com.example.android_tbc_homework_14.utils.MyResponseState
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface MyRepository {
    suspend fun doNetworkCall(): Flow<MyResponseState<Items>>
}