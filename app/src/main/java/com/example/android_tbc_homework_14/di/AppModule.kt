package com.example.android_tbc_homework_14.di

import android.content.Context
import com.example.android_tbc_homework_14.app.BaseApplication
import com.example.android_tbc_homework_14.data.remote.MyApi
import com.example.android_tbc_homework_14.data.repository.MyRepositoryImpl
import com.example.android_tbc_homework_14.domain.MyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): BaseApplication {
        return app as BaseApplication
    }


    @Provides
    @Singleton
    fun provideMyApi(): MyApi {
     return  Retrofit.Builder()
            .baseUrl("https://run.mocky.io/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(MyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMyRepository(api: MyApi): MyRepository {
        return MyRepositoryImpl(api)
    }
}