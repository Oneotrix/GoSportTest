package com.oneotrix.gosporttest.view.utils

import com.oneotrix.gosporttest.domain.models.MealsModel
import com.oneotrix.gosporttest.view.features.main.models.MealModel

object MapperView {

    fun mapToMealModel(model: MealsModel.Meal): MealModel {
        return MealModel(
            title = model.title,
            description = model.description,
            imgUrl = model.img
        )
    }

}