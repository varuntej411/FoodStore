package com.food.store.domain.use_cases

import com.food.store.common.APIDataStatus
import com.food.store.data.Dto.toProduct
import com.food.store.domain.model.GetAllProduct
import com.food.store.domain.repository.ProductRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAllProductsUseCase @Inject constructor(
    private val repository: ProductRepository
) {

    operator fun invoke(): Flow<APIDataStatus<List<GetAllProduct>>> = flow {
        try {
            emit(APIDataStatus.LOADING())
            val products = repository.getAllProducts().map { it.toProduct() }
            emit(APIDataStatus.SUCCESS(products))
        } catch (e: HttpException) {
            emit(APIDataStatus.ERROR(e.localizedMessage ?: "An Unexpected Error Occurred"))
        } catch (e: IOException) {
            emit(APIDataStatus.ERROR(e.message ?: "Couldn't reach server, Check Your Internet Connection"))
        }
    }.flowOn(IO)


}