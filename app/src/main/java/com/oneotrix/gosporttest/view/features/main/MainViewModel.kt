package com.oneotrix.gosporttest.view.features.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oneotrix.gosporttest.domain.usecase.UseCaseGetApplyFilter
import com.oneotrix.gosporttest.domain.usecase.UseCaseGetCategories
import com.oneotrix.gosporttest.domain.usecase.UseCaseGetMeals
import kotlinx.coroutines.launch

class MainViewModel(
    private val useCaseGetApplyFilter: UseCaseGetApplyFilter,
    private val useCaseGetCategories: UseCaseGetCategories,
    private val useCaseGetMeals: UseCaseGetMeals,
): ViewModel() {


    fun getCategories() = viewModelScope.launch {
        useCaseGetMeals.fetch()
    }

}