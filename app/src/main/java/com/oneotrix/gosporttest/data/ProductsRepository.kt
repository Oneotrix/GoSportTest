package com.oneotrix.gosporttest.data

import android.util.Log
import com.oneotrix.gosporttest.data.network.response.BaseModelResponse.*
import com.oneotrix.gosporttest.data.source.NetworkDataSource
import com.oneotrix.gosporttest.domain.repository.IProductsRepository
import javax.inject.Inject

class ProductsRepository @Inject constructor(
    private val networkDataSource: NetworkDataSource
): IProductsRepository {
    override suspend fun getMealsList() {
        val response = networkDataSource.getMealsList()

        when(response) {
            is Success -> {
                Log.d("ProductsRepository", "success")
            }
            is Error -> {
                Log.d("ProductsRepository", "error, message : ${response.message}")
            }
        }
    }

    override suspend fun getCategoriesList() {
        TODO("Not yet implemented")
    }
}