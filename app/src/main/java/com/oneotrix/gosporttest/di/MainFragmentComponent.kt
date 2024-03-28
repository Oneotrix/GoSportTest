package com.oneotrix.gosporttest.di

import com.oneotrix.gosporttest.view.features.main.MainFragment
import dagger.Subcomponent

@Subcomponent
interface MainFragmentComponent {

    fun inject(fragment: MainFragment)

    @Subcomponent.Builder
    interface Builder {
        fun build(): MainFragmentComponent
    }
}