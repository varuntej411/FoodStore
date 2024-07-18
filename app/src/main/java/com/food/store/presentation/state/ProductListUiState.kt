package com.food.store.presentation.state

import com.food.store.domain.model.GetAllProduct

data class ProductListUiState(
    val isLoading: Boolean = false,
    val products: List<GetAllProduct> = emptyList(),
    val error: String = ""
)