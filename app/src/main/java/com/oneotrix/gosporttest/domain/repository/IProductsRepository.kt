package com.oneotrix.gosporttest.domain.repository

import com.oneotrix.gosporttest.domain.models.BaseDomainModel
import com.oneotrix.gosporttest.domain.models.MealsModel

interface IProductsRepository {

    suspend fun getMealsList() : BaseDomainModel<MealsModel>
    suspend fun getCategoriesList()

}