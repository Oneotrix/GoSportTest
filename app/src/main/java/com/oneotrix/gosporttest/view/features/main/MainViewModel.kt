package com.oneotrix.gosporttest.view.features.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oneotrix.gosporttest.domain.models.BaseDomainModel.*
import com.oneotrix.gosporttest.domain.usecase.UseCaseGetApplyFilter
import com.oneotrix.gosporttest.domain.usecase.UseCaseGetCategories
import com.oneotrix.gosporttest.domain.usecase.UseCaseGetMeals
import com.oneotrix.gosporttest.view.features.main.models.CategoryModel
import com.oneotrix.gosporttest.view.features.main.models.MealModel
import com.oneotrix.gosporttest.view.utils.MapperView
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val useCaseGetApplyFilter: UseCaseGetApplyFilter,
    private val useCaseGetCategories: UseCaseGetCategories,
    private val useCaseGetMeals: UseCaseGetMeals,
): ViewModel() {

    private val _data = MutableStateFlow(UiState())
    val data: StateFlow<UiState> = _data.asStateFlow()

    init {
        fetchData()
    }

    private fun fetchData() {
        getCategories()
    }

    private fun getCategories() = viewModelScope.launch {
        val dataMeals = useCaseGetMeals.fetch()

        when(dataMeals) {
            is Success -> {
                val meals = dataMeals.data?.meals
                    ?.map { MapperView.mapToMealModel(it) }
                    ?: emptyList()

                _data.value = UiState(meals = meals)
            }

            is Error -> {
                _data.value = UiState(meals = emptyList())
            }
        }
    }



    data class UiState(
        val categories: List<CategoryModel> = emptyList(),
        val meals: List<MealModel> = emptyList()
    )

}