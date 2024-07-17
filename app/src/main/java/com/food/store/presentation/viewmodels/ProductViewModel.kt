package com.food.store.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.food.store.common.APIDataStatus
import com.food.store.domain.use_cases.GetAllProductsUseCase
import com.food.store.presentation.state.ProductListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val getAllProductsUseCase: GetAllProductsUseCase
) : ViewModel() {

    private val _states = MutableStateFlow(ProductListState())
    val states: StateFlow<ProductListState> = _states.asStateFlow()

    // we can use *mutable-state-of* but it cannot handle large data like mutable-stateflow
    // private val _state = mutableStateOf(ProductListState())
    // val state: State<ProductListState> = _state

    init {
        getAllProducts()
    }

    private fun getAllProducts() {
        getAllProductsUseCase().onEach { result ->
            when (result) {
                is APIDataStatus.LOADING -> {
                    _states.value = ProductListState(isLoading = true)
                }

                is APIDataStatus.SUCCESS -> {
                    _states.value = ProductListState(products = result.data ?: emptyList())
                }

                is APIDataStatus.ERROR -> {
                    _states.value = ProductListState(error = result.message ?: "An Unexpected Error Occurred")
                }
            }
        }.launchIn(viewModelScope)
    }
}