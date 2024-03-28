package com.oneotrix.gosporttest.view.features.main.ui.recycler.banners

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.oneotrix.gosporttest.databinding.ItemBannerBinding

class AdapterBanners(
    private val list: List<Int>
): Adapter<ViewHolderBanner>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderBanner {
        return ViewHolderBanner(
            binding = ItemBannerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolderBanner, position: Int) {
    }
}