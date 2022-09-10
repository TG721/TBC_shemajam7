package com.example.android_tbc_shemajamebeli7.domain

import com.example.android_tbc_shemajamebeli7.data.model.Items
import com.example.android_tbc_shemajamebeli7.utils.MyResponseState
import kotlinx.coroutines.flow.Flow

interface MyRepository {
    suspend fun doNetworkCall(): Flow<MyResponseState<Items>>
}