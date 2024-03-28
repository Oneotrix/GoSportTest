package com.oneotrix.gosporttest.view.features.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.oneotrix.gosporttest.App
import com.oneotrix.gosporttest.databinding.FragmentMainBinding
import com.oneotrix.gosporttest.view.BaseFragment
import com.oneotrix.gosporttest.view.features.main.ui.recycler.banners.AdapterBanners
import com.oneotrix.gosporttest.view.features.main.ui.recycler.categories.AdapterFilters
import com.oneotrix.gosporttest.view.features.main.ui.recycler.meals.AdapterMeals
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class MainFragment: BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    private val adapterMeals by lazy {
        AdapterMeals()
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
        setAdapters()
        observeData()
    }

    private fun observeData() {
        viewModel.data
            .onEach {
                adapterMeals.submitList(it.meals)
            }
            .launchIn(lifecycleScope)
    }

    private fun setAdapters() {
        binding.rvMeals.adapter = adapterMeals
        binding.rvBanners.adapter = adapterBanners
        binding.rvFilters.adapter = adapterFilters
    }



    companion object {
        fun newInstance() = MainFragment()
    }
}