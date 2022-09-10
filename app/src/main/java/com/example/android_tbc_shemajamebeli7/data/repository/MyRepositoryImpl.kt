package com.example.android_tbc_shemajamebeli7.data.repository

import com.example.android_tbc_shemajamebeli7.data.model.Items
import com.example.android_tbc_shemajamebeli7.data.remote.MyApi
import com.example.android_tbc_shemajamebeli7.domain.MyRepository
import com.example.android_tbc_shemajamebeli7.utils.MyResponseState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class MyRepositoryImpl @Inject constructor(
    private val api: MyApi
) : MyRepository {
    override suspend fun doNetworkCall(): Flow<MyResponseState<Items>> = flow {
        try {
            val response: Response<Items> = api.doNetworkCall()
            val body: Items? = response.body()
            if (response.isSuccessful && body != null) {
                emit(MyResponseState.Success(body))
            } else {
                emit(MyResponseState.Error(response.errorBody().toString()))
            }
        } catch (e: Exception){
                emit(MyResponseState.Error(e.message.toString()))
        }
    }

}