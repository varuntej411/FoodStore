package com.food.store.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodStoreDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(productEntity: ProductEntity): Long


    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateAll(productEntity: ProductEntity)

    @Delete
    suspend fun deleteProducts(productEntity: ProductEntity)

    @Query("SELECT * FROM product_table")
    fun getAllProducts(): Flow<List<ProductEntity>>

    @Query("SELECT * From product_table WHERE id = :id")
    suspend fun getProductById(id: String): ProductEntity

    @Query("SELECT * FROM product_table WHERE url=:url")
    suspend fun getProductByUrl(url: String): ProductEntity?

    @Query("SELECT *  FROM product_table ORDER BY price ASC")
    suspend fun getProductsSortASC(): Flow<List<ProductEntity>>

    @Query("SELECT * FROM product_table ORDER BY price DESC")
    suspend fun getProductsSortDSC(): Flow<List<ProductEntity>>

    @Query("DELETE FROM product_table")
    suspend fun deleteAllArticles()
}