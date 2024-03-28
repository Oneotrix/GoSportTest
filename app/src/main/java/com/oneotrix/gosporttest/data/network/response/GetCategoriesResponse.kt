package com.oneotrix.gosporttest.data.network.response

import kotlinx.serialization.Serializable

@Serializable
data class GetCategoriesResponse(
    var categories: ArrayList<Category> = arrayListOf()
) {
    @Serializable
    data class Category(
        var idCategory: String? = null,
        var strCategory: String? = null,
        var strCategoryThumb: String? = null,
        var strCategoryDescription: String? = null,
    )
}
