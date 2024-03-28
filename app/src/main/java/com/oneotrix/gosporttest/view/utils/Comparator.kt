package com.oneotrix.gosporttest.view.utils

import androidx.recyclerview.widget.DiffUtil
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
}