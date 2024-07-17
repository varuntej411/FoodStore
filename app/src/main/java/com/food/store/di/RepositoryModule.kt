package com.food.store.di

import com.food.store.data.remote.FoodStoreApis
import com.food.store.data.repository.ProductRepositoryImpl
import com.food.store.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun provideProductRepository(foodStoreApis: FoodStoreApis) : ProductRepository {
        return ProductRepositoryImpl(foodStoreApis)
    }
}