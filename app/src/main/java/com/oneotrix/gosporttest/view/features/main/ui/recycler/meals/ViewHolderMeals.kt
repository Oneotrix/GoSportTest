package com.oneotrix.gosporttest.view.features.main.ui.recycler.meals

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.oneotrix.gosporttest.App
import com.oneotrix.gosporttest.databinding.ItemProductBinding
import com.oneotrix.gosporttest.view.features.main.models.MealModel

class ViewHolderMeals(
    private val binding: ItemProductBinding
): ViewHolder(binding.root) {

    fun bind(item: MealModel) {
        binding.tvTitle.text = item.title
        binding.tvDescription.text = item.description
        picasso.load(item.imgUrl).into(binding.ivProduct)
    }



    companion object {
        val picasso = App.appComponent.providePicasso()
    }
}