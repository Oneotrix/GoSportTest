package com.oneotrix.gosporttest.view.features.main.ui.recycler.products

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.oneotrix.gosporttest.databinding.ItemProductBinding

class AdapterProducts(
    val list: List<Int>
): Adapter<ViewHolderProduct>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderProduct {
        return ViewHolderProduct(
            binding = ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolderProduct, position: Int) {

    }
}