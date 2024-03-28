package com.oneotrix.gosporttest.view.features.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.oneotrix.gosporttest.domain.usecase.UseCaseGetApplyFilter
import com.oneotrix.gosporttest.domain.usecase.UseCaseGetCategories
import com.oneotrix.gosporttest.domain.usecase.UseCaseGetMeals
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(
    private val useCaseGetApplyFilter: UseCaseGetApplyFilter,
    private val useCaseGetCategories: UseCaseGetCategories,
    private val useCaseGetMeals: UseCaseGetMeals,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            useCaseGetApplyFilter,
            useCaseGetCategories,
            useCaseGetMeals
        ) as T
    }
}