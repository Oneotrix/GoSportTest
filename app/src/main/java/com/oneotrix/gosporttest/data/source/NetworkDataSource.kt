package com.oneotrix.gosporttest.data.source

import com.oneotrix.gosporttest.data.network.Api
import com.oneotrix.gosporttest.data.network.response.BaseModelResponse
import com.oneotrix.gosporttest.data.network.response.BaseModelResponse.*
import com.oneotrix.gosporttest.data.network.response.GetMealsResponse
import retrofit2.HttpException
import javax.inject.Inject

class NetworkDataSource @Inject constructor(
    private val apiService: Api,
) {

    suspend fun getMealsList() : BaseModelResponse<GetMealsResponse> {
        return try {
            val data = apiService.getMealsList()
            Success(data)
        } catch (e: HttpException) {
            Error(e.message.orEmpty())
        }
    }


}