package com.food.store.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_table")
class ProductEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val productName: String,
    val url: String,
    val price: Int = 0,
)