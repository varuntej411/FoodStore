package com.food.store.data.Dto

import com.food.store.domain.model.GetAllProduct

data class GetAllProductDto(
    val category: String,
    val description: String,
    val id: Long,
    val image: String,
    val price: String,
    val title: String
)

fun GetAllProductDto.toProduct() : GetAllProduct {
    return GetAllProduct(
        id = id,
        description = description,
        image = image,
        price = price,
        title = title,
        category = category
    )
}