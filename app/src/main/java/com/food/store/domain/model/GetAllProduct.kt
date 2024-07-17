package com.food.store.domain.model

data class GetAllProduct(
    val category: String,
    val description: String,
    val id: Long,
    val image: String,
    val price: String,
    val title: String
)
