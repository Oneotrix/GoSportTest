package com.oneotrix.gosporttest.view.features.main.ui.recycler.categories

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.oneotrix.gosporttest.databinding.ItemFilterBinding
import com.oneotrix.gosporttest.view.features.main.models.CategoryModel

class ViewHolderCategory(
    private val binding: ItemFilterBinding
): ViewHolder(binding.root) {
    fun bind(item: CategoryModel, callback: (CategoryModel) -> Unit) {
        binding.chpFilter.text = item.title
        binding.chpFilter.isChecked = item.isChecked

        binding.root.setOnClickListener {
            callback.invoke(item)
        }
    }
}