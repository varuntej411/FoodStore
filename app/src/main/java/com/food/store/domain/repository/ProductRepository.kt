package com.food.store.domain.repository

import com.food.store.data.Dto.GetAllProductDto

interface ProductRepository {
    suspend fun getAllProducts(): List<GetAllProductDto>


    // for offline data
    // suspend fun insertProducts(product: ProductEntity)
    // suspend fun updateProducts(product: ProductEntity)
    // suspend fun deleteProducts(product: ProductEntity)
    // fun getAllOfflineProducts(): Flow<List<ProductEntity>>
}