package com.oneotrix.gosporttest.data.network
import com.oneotrix.gosporttest.data.network.response.GetCategoriesResponse
import com.oneotrix.gosporttest.data.network.response.GetMealsResponse
import retrofit2.http.GET
interface Api {

    @GET("api/json/v1/1/search.php?s")
    suspend fun getMealsList() : GetMealsResponse


    @GET("api/json/v1/1/categories.php")
    suspend fun getCategories() : GetCategoriesResponse


    companion object {
        const val BASE_URL = "http://themealdb.com/"
    }
}