package com.oneotrix.gosporttest.view.features.main.ui.recycler.meals

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.oneotrix.gosporttest.databinding.ItemProductBinding
import com.oneotrix.gosporttest.view.features.main.models.MealModel
import com.oneotrix.gosporttest.view.utils.Comparator

class AdapterMeals(): ListAdapter<MealModel, ViewHolderMeals>(Comparator.mealsListDiffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderMeals {
        return ViewHolderMeals(
            binding = ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolderMeals, position: Int) {
        holder.bind(getItem(position))
    }
}