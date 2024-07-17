package com.food.store.data.remote

import com.food.store.data.Dto.GetAllProductDto
import retrofit2.http.GET

interface FoodStoreApis {

    @GET
    suspend fun getAllProducts() : List<GetAllProductDto>
}