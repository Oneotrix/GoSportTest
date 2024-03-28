package com.oneotrix.gosporttest.di

import com.oneotrix.gosporttest.data.network.Api
import dagger.Component

@Component(
    modules = [
        ModuleRetrofit::class,
        OkHttpModule::class,
        AppSubcomponents::class,
        RepositoryModule::class,
    ]
)
interface AppComponent {

    fun provideApiService() : Api

    fun provideMainFragmentComponentBuilder() : MainFragmentComponent.Builder

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
    }
}