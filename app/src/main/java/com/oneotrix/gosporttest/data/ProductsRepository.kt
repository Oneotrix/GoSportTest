package com.oneotrix.gosporttest.data

import com.oneotrix.gosporttest.data.mapper.MapperData
import com.oneotrix.gosporttest.data.network.response.BaseModelResponse.*
import com.oneotrix.gosporttest.data.network.response.GetMealsResponse
import com.oneotrix.gosporttest.data.source.NetworkDataSource
import com.oneotrix.gosporttest.domain.models.BaseDomainModel
import com.oneotrix.gosporttest.domain.models.MealsModel
import com.oneotrix.gosporttest.domain.repository.IProductsRepository
import javax.inject.Inject

class ProductsRepository @Inject constructor(
    private val networkDataSource: NetworkDataSource
): IProductsRepository {
    override suspend fun getMealsList(): BaseDomainModel<MealsModel> {
        val response = networkDataSource.getMealsList()


        return when(response) {
            is Success -> {
                val data = response.data ?: GetMealsResponse()

                BaseDomainModel.Success(
                    data = MapperData.mapMealsListToDomain(data)
                )
            }
            is Error -> {
                BaseDomainModel.Error(message = response.message)
            }
        }
    }

    override suspend fun getCategoriesList() {
        TODO("Not yet implemented")
    }
}