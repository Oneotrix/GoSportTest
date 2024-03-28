package com.oneotrix.gosporttest.view.features.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.oneotrix.gosporttest.App
import com.oneotrix.gosporttest.databinding.FragmentMainBinding
import com.oneotrix.gosporttest.view.BaseFragment
import com.oneotrix.gosporttest.view.features.main.ui.recycler.banners.AdapterBanners
import com.oneotrix.gosporttest.view.features.main.ui.recycler.categories.AdapterFilters
import com.oneotrix.gosporttest.view.features.main.ui.recycler.products.AdapterProducts
import javax.inject.Inject

class MainFragment: BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    private val adapterProducts by lazy {
        AdapterProducts(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9 , 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20))
    }

    private val adapterBanners by lazy {
        AdapterBanners(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9 , 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20))
    }

    private val adapterFilters by lazy {
        AdapterFilters(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9 , 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20))
    }

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory

    private val viewModel: MainViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        App.appComponent.provideMainFragmentComponentBuilder()
            .build()
            .inject(this@MainFragment)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvMeals.adapter = adapterProducts
        binding.rvBanners.adapter = adapterBanners
        binding.rvFilters.adapter = adapterFilters

        viewModel.getCategories()


    }



    companion object {
        fun newInstance() = MainFragment()
    }
}