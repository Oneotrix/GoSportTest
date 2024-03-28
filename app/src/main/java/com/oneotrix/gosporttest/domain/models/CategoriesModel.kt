package com.oneotrix.gosporttest.domain.models

data class CategoriesModel(
    val categories: List<Category>
) {
    data class Category(
        val title: String
    )
}
