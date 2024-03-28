package com.oneotrix.gosporttest.view.utils

import androidx.recyclerview.widget.DiffUtil
import com.oneotrix.gosporttest.view.features.main.models.CategoryModel
import com.oneotrix.gosporttest.view.features.main.models.MealModel

object Comparator {

    val mealsListDiffUtil = object : DiffUtil.ItemCallback<MealModel>() {
        override fun areItemsTheSame(oldItem: MealModel, newItem: MealModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: MealModel, newItem: MealModel) =
            oldItem.title == newItem.title &&
            oldItem.description == newItem.description &&
            oldItem.imgUrl == newItem.imgUrl
    }

    val categoriesListDiffUtil = object : DiffUtil.ItemCallback<CategoryModel>() {
        override fun areItemsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean {
            return oldItem.isChecked == newItem.isChecked
        }

    }
}