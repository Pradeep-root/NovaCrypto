package com.pradeep.novacrypto.di

import com.pradeep.novacrypto.data.repository.MarketsRepositoryImpl
import com.pradeep.novacrypto.domain.repository.MarketsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module()
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsMarketRepository(marketsRepositoryImpl: MarketsRepositoryImpl): MarketsRepository
}