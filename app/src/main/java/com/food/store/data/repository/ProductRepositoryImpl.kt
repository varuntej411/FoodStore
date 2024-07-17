package com.food.store.data.repository

import com.food.store.data.Dto.GetAllProductDto
import com.food.store.data.remote.FoodStoreApis
import com.food.store.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val foodStoreApis: FoodStoreApis
) : ProductRepository {

    override suspend fun getAllProducts(): List<GetAllProductDto> {
        return foodStoreApis.getAllProducts()
    }

}