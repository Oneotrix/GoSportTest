package com.oneotrix.gosporttest.data.source

import com.oneotrix.gosporttest.data.network.Api
import com.oneotrix.gosporttest.data.network.response.BaseModelResponse
import com.oneotrix.gosporttest.data.network.response.BaseModelResponse.*
import com.oneotrix.gosporttest.data.network.response.GetCategoriesResponse
import com.oneotrix.gosporttest.data.network.response.GetMealsResponse
import javax.inject.Inject

class NetworkDataSource @Inject constructor(
    private val apiService: Api,
) {

    suspend fun getMealsList() : BaseModelResponse<GetMealsResponse> {
        return try {
            val data = apiService.getMealsList()
            Success(data)
        } catch (e: Exception) {
            Error(e.message.orEmpty())
        }
    }

    suspend fun getCategoriesList() : BaseModelResponse<GetCategoriesResponse> {
        return try {
            val data = apiService.getCategories()
            Success(data)
        } catch (e: Exception) {
            Error(e.message.orEmpty())
        }
    }


}