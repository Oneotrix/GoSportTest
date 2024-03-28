package com.oneotrix.gosporttest

import android.app.Application
import com.oneotrix.gosporttest.di.AppComponent
import com.oneotrix.gosporttest.di.DaggerAppComponent

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .build()

    }

    companion object {
        lateinit var appComponent: AppComponent
    }
}