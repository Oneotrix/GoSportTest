package com.oneotrix.gosporttest.di

import com.oneotrix.gosporttest.data.ProductsRepository
import com.oneotrix.gosporttest.data.source.NetworkDataSource
import com.oneotrix.gosporttest.domain.repository.IProductsRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun provideProductsRepository(
        networkDataSource: NetworkDataSource
    ) : IProductsRepository {
        return ProductsRepository(networkDataSource)
    }

}