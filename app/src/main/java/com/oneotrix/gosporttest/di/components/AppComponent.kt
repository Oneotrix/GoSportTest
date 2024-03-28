package com.oneotrix.gosporttest.di.components

import android.content.Context
import com.oneotrix.gosporttest.data.local.room.AppDatabase
import com.oneotrix.gosporttest.data.network.Api
import com.oneotrix.gosporttest.di.modules.ModuleRetrofit
import com.oneotrix.gosporttest.di.modules.OkHttpModule
import com.oneotrix.gosporttest.di.modules.PicassoModule
import com.oneotrix.gosporttest.di.modules.RepositoryModule
import com.oneotrix.gosporttest.di.modules.RoomModule
import com.squareup.picasso.Picasso
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ModuleRetrofit::class,
        OkHttpModule::class,
        AppSubcomponents::class,
        RepositoryModule::class,
        PicassoModule::class,
        RoomModule::class,
    ]
)
interface AppComponent {

    fun provideApiService() : Api

    fun providePicasso(): Picasso

    fun provideAppDatabase(): AppDatabase

    fun provideMainFragmentComponentBuilder() : MainFragmentComponent.Builder

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context) : Builder
        fun build(): AppComponent
    }
}