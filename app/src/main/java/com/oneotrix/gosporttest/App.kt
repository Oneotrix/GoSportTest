package com.oneotrix.gosporttest

import android.app.Application
import com.oneotrix.gosporttest.di.components.AppComponent
import com.oneotrix.gosporttest.di.components.DaggerAppComponent

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .context(this@App)
            .build()

    }

    companion object {
        lateinit var appComponent: AppComponent
    }
}