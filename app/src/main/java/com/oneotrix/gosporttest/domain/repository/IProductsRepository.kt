package com.oneotrix.gosporttest.domain.repository

interface IProductsRepository {

    suspend fun getMealsList()
    suspend fun getCategoriesList()

}