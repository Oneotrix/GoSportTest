package com.oneotrix.gosporttest.view.features.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.oneotrix.gosporttest.domain.usecase.UseCaseGetApplyCategory
import com.oneotrix.gosporttest.domain.usecase.UseCaseGetCategories
import com.oneotrix.gosporttest.domain.usecase.UseCaseGetMeals
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(
    private val useCaseGetApplyCategory: UseCaseGetApplyCategory,
    private val useCaseGetCategories: UseCaseGetCategories,
    private val useCaseGetMeals: UseCaseGetMeals,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            useCaseGetApplyCategory,
            useCaseGetCategories,
            useCaseGetMeals
        ) as T
    }
}