package com.oneotrix.gosporttest.domain.usecase

import com.oneotrix.gosporttest.domain.repository.IProductsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UseCaseGetApplyCategory @Inject constructor(
    private val repository: IProductsRepository
) {

    suspend fun apply(category: String = "") = withContext(Dispatchers.IO) {
        return@withContext repository.getMealsByCategory(category)
    }

}