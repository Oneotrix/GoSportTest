package com.oneotrix.gosporttest.data.source

import com.oneotrix.gosporttest.data.local.room.AppDatabase
import com.oneotrix.gosporttest.data.mapper.MapperData
import com.oneotrix.gosporttest.data.network.response.GetCategoriesResponse
import com.oneotrix.gosporttest.data.network.response.GetMealsResponse
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val app: AppDatabase
) {

    fun getAllMeals() = app.mealDao().getAll()

    fun getAllCategories() = app.categoryDao().getAll()

    suspend fun insertAllMeals(getMealsResponse: GetMealsResponse) {
        val meals = getMealsResponse.meals.map {
            MapperData.mapMealToRoom(it)
        }

        app.mealDao().insertAll(meals)
    }

    suspend fun insertAllCategory(getCategoriesResponse: GetCategoriesResponse) {
        val categories = getCategoriesResponse.categories.map {
            MapperData.mapCategoryToRoom(it)
        }

        app.categoryDao().insertAll(categories)
    }

    suspend fun getMealsByCategory(category: String) = app.mealDao().filterByCategory(category)

}