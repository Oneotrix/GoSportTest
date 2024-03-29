package com.oneotrix.gosporttest.view.features.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oneotrix.gosporttest.domain.usecase.UseCaseGetApplyCategory
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
    private val useCaseGetApplyCategory: UseCaseGetApplyCategory,
    private val useCaseGetCategories: UseCaseGetCategories,
    private val useCaseGetMeals: UseCaseGetMeals,
): ViewModel() {

    private val _data = MutableStateFlow(UiState())
    val data: StateFlow<UiState> = _data.asStateFlow()

    init {
        fetchData()
    }

    private fun fetchData() {
        getMeals()
        getCategories()
    }

    private fun getMeals() = viewModelScope.launch {
        useCaseGetMeals.fetch().collect { list ->
            _data.value = UiState(
                meals = list.map { MapperView.mapMeal(it) },
                categories = _data.value.categories,
            )
        }
    }

    private fun getCategories() = viewModelScope.launch {
        useCaseGetCategories.fetch().collect { list ->
            _data.value = UiState(
                meals = _data.value.meals,
                categories = list.map { MapperView.mapCategory(it) },
            )
        }
    }

    fun checkCategory(category: CategoryModel) = viewModelScope.launch {
        val categories = updateCategoriesState(category)

        if (category.isChecked) {
            useCaseGetApplyCategory.apply().collect { list ->
                _data.value = UiState(
                    meals = list.map { MapperView.mapMeal(it) },
                    categories = categories
                )
            }
        }
        else {
            useCaseGetApplyCategory.apply(category.title).collect { list ->
                _data.value = UiState(
                    meals = list.map { MapperView.mapMeal(it) },
                    categories = categories
                )
            }
        }

    //_data.value = _data.value.copy(categories = categories)
    }

    private fun updateCategoriesState(category: CategoryModel): List<CategoryModel> {
        val categories =_data.value.categories.map {
            when(category.isChecked) {
                true -> {
                    it.copy(isChecked = false)
                }
                false -> {
                    if (it == category) {
                        it.copy(isChecked = true)
                    } else {
                        it.copy(isChecked = false)
                    }
                }
            }
        }

        return categories
    }

    data class UiState(
        val categories: List<CategoryModel> = emptyList(),
        val meals: List<MealModel> = emptyList()
    )
}
