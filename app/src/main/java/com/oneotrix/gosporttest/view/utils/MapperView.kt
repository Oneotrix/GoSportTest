package com.oneotrix.gosporttest.view.utils

import com.oneotrix.gosporttest.data.local.room.category.Category
import com.oneotrix.gosporttest.data.local.room.meal.Meal
import com.oneotrix.gosporttest.view.features.main.models.CategoryModel
import com.oneotrix.gosporttest.view.features.main.models.MealModel

object MapperView {

    fun mapMeal(meal: Meal): MealModel {
        return MealModel(
            title = meal.title,
            description = meal.description,
            imgUrl = meal.imgUrl
        )
    }

    fun mapCategory(category: Category): CategoryModel {
        return CategoryModel(
            title = category.name,
            isChecked = false,
        )
    }

}