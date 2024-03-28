package com.oneotrix.gosporttest.view.features.main.ui.recycler.categories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.oneotrix.gosporttest.databinding.ItemFilterBinding

class AdapterFilters(
    private val list: List<Int>
): Adapter<ViewHolderFilter>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderFilter {
        return ViewHolderFilter(
            binding = ItemFilterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolderFilter, position: Int) {
    }
}