package com.oneotrix.gosporttest.data.mapper

import com.oneotrix.gosporttest.data.local.room.category.Category
import com.oneotrix.gosporttest.data.local.room.meal.Meal
import com.oneotrix.gosporttest.data.network.response.GetCategoriesResponse
import com.oneotrix.gosporttest.data.network.response.GetMealsResponse

object MapperData {

    fun mapMealToRoom(
        meal: GetMealsResponse.Meal
    ): Meal {
        val description = "" +
                "${meal.strIngredient1}, " +
                "${meal.strIngredient2}, " +
                "${meal.strIngredient3}, " +
                "${meal.strIngredient4}," +
                "${meal.strIngredient5}, " +
                "${meal.strIngredient6}," +
                "${meal.strIngredient7}"
        return Meal(
            id = meal.idMeal.toInt(),
            title = meal.strMeal.orEmpty(),
            category = meal.strTags.orEmpty(),
            description = description,
            imgUrl = meal.strMealThumb.orEmpty(),
        )
    }

    fun mapCategoryToRoom(category: GetCategoriesResponse.Category): Category {
        return Category(
            id = category.idCategory.orEmpty().toInt(),
            name = category.strCategory.orEmpty()
        )
    }
}