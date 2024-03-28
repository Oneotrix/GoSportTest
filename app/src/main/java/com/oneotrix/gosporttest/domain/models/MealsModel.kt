package com.oneotrix.gosporttest.domain.models

import com.squareup.picasso.RequestCreator

data class MealsModel(
    val meals: List<Meal>
) {
    data class Meal(
        val id: String,
        val title: String,
        val description:String,
        val img: String,
    )
}
