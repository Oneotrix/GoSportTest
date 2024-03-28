package com.oneotrix.gosporttest.data.mapper

import com.oneotrix.gosporttest.data.network.response.GetMealsResponse
import com.oneotrix.gosporttest.domain.models.MealsModel

object MapperData {

    fun mapMealToDomain(
        meal: GetMealsResponse.Meal,
    ): MealsModel.Meal {

        val description = "" +
                "${meal.strIngredient1}, " +
                "${meal.strIngredient2}, " +
                "${meal.strIngredient3}, " +
                "${meal.strIngredient4}," +
                "${meal.strIngredient5}, " +
                "${meal.strIngredient6}," +
                "${meal.strIngredient7}"

        return MealsModel.Meal(
            id = meal.idMeal,
            title = meal.strMeal.orEmpty(),
            description = description,
            img = meal.strMealThumb.orEmpty()
        )
    }

    fun mapMealsListToDomain(
        list: GetMealsResponse,
    ): MealsModel = MealsModel(meals = list.meals.map { mapMealToDomain(it) })
}