package com.oneotrix.gosporttest.domain.repository

import com.oneotrix.gosporttest.data.local.room.category.Category
import com.oneotrix.gosporttest.data.local.room.meal.Meal
import kotlinx.coroutines.flow.Flow

interface IProductsRepository {

    suspend fun getMealsList() : Flow<List<Meal>>
    suspend fun getMealsByCategory(category: String) : Flow<List<Meal>>
    suspend fun getCategoriesList() : Flow<List<Category>>

}