package com.oneotrix.gosporttest.data

import com.oneotrix.gosporttest.data.local.room.category.Category
import com.oneotrix.gosporttest.data.local.room.meal.Meal
import com.oneotrix.gosporttest.data.network.response.BaseModelResponse.*
import com.oneotrix.gosporttest.data.network.response.GetCategoriesResponse
import com.oneotrix.gosporttest.data.network.response.GetMealsResponse
import com.oneotrix.gosporttest.data.source.LocalDataSource
import com.oneotrix.gosporttest.data.source.NetworkDataSource
import com.oneotrix.gosporttest.domain.repository.IProductsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductsRepository @Inject constructor(
    private val networkDataSource: NetworkDataSource,
    private val localDataSource: LocalDataSource
): IProductsRepository {
    override suspend fun getMealsList(): Flow<List<Meal>> {
        val response = networkDataSource.getMealsList()

        return when(response) {
            is Success -> {
                val data = response.data ?: GetMealsResponse()

                localDataSource.insertAllMeals(data)
                localDataSource.getAllMeals()
            }
            is Error -> {
                localDataSource.getAllMeals()
            }
        }
    }

    override suspend fun getMealsByCategory(category: String): Flow<List<Meal>> {
        return try {
            if (category.isNotBlank()) localDataSource.getMealsByCategory(category)
            else localDataSource.getAllMeals()
        } catch (e: Exception) {
            flow {
                emit(emptyList())
            }
        }
    }

    override suspend fun getCategoriesList(): Flow<List<Category>> {

        val response = networkDataSource.getCategoriesList()

        return when(response) {
            is Success -> {
                val data = response.data ?: GetCategoriesResponse()

                localDataSource.insertAllCategory(data)
                localDataSource.getAllCategories()
            }
            is Error -> {
                localDataSource.getAllCategories()
            }
        }

    }
}