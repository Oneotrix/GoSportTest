package com.oneotrix.gosporttest.view.features.main.ui.recycler.categories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.oneotrix.gosporttest.databinding.ItemFilterBinding
import com.oneotrix.gosporttest.view.features.main.models.CategoryModel
import com.oneotrix.gosporttest.view.utils.Comparator

class AdapterCategory(
    private val callback: (CategoryModel) -> Unit
): ListAdapter<CategoryModel, ViewHolderCategory>(Comparator.categoriesListDiffUtil){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCategory {
        return ViewHolderCategory(
            binding = ItemFilterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: ViewHolderCategory, position: Int) {
        holder.bind(getItem(position), callback)
    }
}