package com.example.android_tbc_homework_14.di

import com.example.android_tbc_homework_14.data.repository.MyRepositoryImpl
import com.example.android_tbc_homework_14.domain.MyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindMyRepository(
    myRepositoryImpl: MyRepositoryImpl
    ): MyRepository
}