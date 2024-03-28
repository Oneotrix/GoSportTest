package com.oneotrix.gosporttest.domain.usecase

import com.oneotrix.gosporttest.domain.repository.IProductsRepository
import javax.inject.Inject

class UseCaseGetApplyFilter @Inject constructor(
    private val repository: IProductsRepository
) {


}