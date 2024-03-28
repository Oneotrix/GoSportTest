package com.oneotrix.gosporttest.di

import com.oneotrix.gosporttest.data.network.Api
import dagger.Component

@Component(
    modules = [
        ModuleRetrofit::class,
        OkHttpModule::class,
    ]
)
interface AppComponent {

    fun provideApiService() : Api

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
    }
}